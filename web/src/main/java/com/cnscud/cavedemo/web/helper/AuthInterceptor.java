package com.cnscud.cavedemo.web.helper;


import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.web.MsgConstants;
import com.cnscud.cavedemo.web.feignclient.UserServiceClient;
import com.cnscud.cavedemo.web.utils.web.RequestUtils;
import com.cnscud.xpower.utils.CookieUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static com.cnscud.cavedemo.web.utils.web.RequestUtils.encodeURL;
import static com.cnscud.cavedemo.web.utils.web.RequestUtils.getRequestURL;


/**
 * Spring 认证拦截器
 *
 * @author adyliu (imxylz@gmail.com)
 * @since 2012/10/23
 */
@Component
public class AuthInterceptor implements HandlerInterceptor, Ordered {


    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserServiceClient userServiceClient;

    protected String loginUrlPrefix = "/login/?referer=";
    /**
     * 静态资源（这些资源无需走整个验证拦截器）
     */
    protected Set<String> _staticlist;

    /**
     * 白名单资源（这些资源走整个验证拦截器，但不跳转到登陆页)
     */
    protected Set<String> _whitelist;
    //
    final AntPathMatcher pathMatcher = new AntPathMatcher();

    public AuthInterceptor() {
    }

    protected boolean _matchPath(String uri, Set<String> list) {
        return list != null && list.stream().anyMatch(x -> pathMatcher.match(x, uri));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(logger.isDebugEnabled()) {
            //logger.debug("call AuthInterceptor ...");
        }

        //
        // ① 如果是静态资源，直接通过，且无需解析cookie以及验证用户身份，返回true
        // ② 解析cookie，判断用户是否登录
        //
        // ④ 如果未登录且页面需要登录信息，则返回false
        // ⑤ 返回true


        final String uri = request.getRequestURI();
        if (_matchPath(uri, _staticlist)) { // 匹配静态资源
            //request.setAttribute(IS_STATIC_RESOURCE, Boolean.TRUE);
            return true;// 所有静态资源直接无视
        }

        boolean isLogin = parseCookieSession(request, response); // 解析cookie


        boolean withWhitelist = _matchPath(uri, _whitelist);// 匹配白名单
        if (withWhitelist) {
            return true;
        }

        if (!isLogin && !checkLoginRequired(request, response, handler)) {
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        try {
            if (ex != null) {
                if (ex instanceof JsonResponseException) {
                    logger.error(request.getRequestURL() + ", " + ex.getMessage());//hold JsonResponseException
                }
                else {
                    logger.error(request.getRequestURL() + ", ", ex);
                }
            }
        }
        finally {
            //UserIdHolder.clearUserId();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        Long start = (Long) request.getAttribute("__start__");
        if (start != null) {
            request.setAttribute("__cost__", System.currentTimeMillis() - start.longValue());
        }
    }

    /**
     * 解析票据cookie
     *
     * @return 如果用户登录，则返回true
     */
    protected boolean parseCookieSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 处理cookie的逻辑 ,request 中放入userId

        Cookie loginCookie = CookieUtils.getCookie(request, MsgConstants.Cookie_LoginToken);
        if (loginCookie == null) {
            return false;
        }
        String token = loginCookie.getValue();
        int userid = JWTHelper.getUserid(token);
        boolean verified = JWTHelper.verify(token);
        if (!verified) {
            //删除错误cookie
            CookieUtils.deleteCookie(response, loginCookie, MsgConstants.Cookie_Domain, MsgConstants.Cookie_Path);
            return false;
        }

        User user = userServiceClient.queryUser(userid);

        request.setAttribute(MsgConstants.CURRENT_USER_ATTRIBUTE, user);

        return true;
    }


    /**
     * 检查登录需求
     *
     * @return true表示OK，false表示登录失败，已经跳转到登录页面或者ajax结果
     */
    protected boolean checkLoginRequired(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof org.springframework.web.servlet.resource.ResourceHttpRequestHandler) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRequired loginRequired = handlerMethod.getMethodAnnotation(LoginRequired.class);
        if (loginRequired == null) {
            loginRequired = handlerMethod.getBeanType().getAnnotation(LoginRequired.class);
        }

        if (loginRequired != null && loginRequired.value() ) {
            if (handlerMethod.getMethodAnnotation(ResponseBody.class) != null) {
                response.setCharacterEncoding("UTF-8");
                RequestUtils.writeResponse(request, response, "{\"code\": 900,\"msg\": \"需要登录\"}");
                return false;
            }
            Cookie redirectCookie = CookieUtils.getCookie(request, "_redirect");
            String referer;
            if (redirectCookie != null) {
                referer = redirectCookie.getValue();
                CookieUtils.deleteCookie(response, redirectCookie, CookieUtils.DEFAULT_DOMAIN, "/");
            }
            else {
                referer = encodeURL(getRequestURL(request));
            }
            response.setCharacterEncoding("UTF-8");
            response.sendRedirect(loginUrlPrefix + referer);
            return false;
        }

        return true;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }


    public void setLoginUrlPrefix(String loginUrlPrefix) {
        this.loginUrlPrefix = loginUrlPrefix;
    }


    @Value("${web.url.static-list}")
    public void setStaticlist(String staticlist) {
        if (staticlist != null) {
            this._staticlist = Arrays.stream(staticlist.split(","))//
                    .filter(x -> !x.trim().isEmpty()).map(x -> x.trim()).collect(Collectors.toSet());
        }
    }

    @Value("${web.url.white-list}")
    public void setWhitelist(String whitelist) {
        if (whitelist != null) {
            this._whitelist = Arrays.stream(whitelist.split(","))//
                    .filter(x -> !x.trim().isEmpty()).map(x -> x.trim()).collect(Collectors.toSet());
        }
    }

    public void setUserServiceClient(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }
}
