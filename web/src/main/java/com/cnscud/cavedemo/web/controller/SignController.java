package com.cnscud.cavedemo.web.controller;

import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.web.MsgConstants;
import com.cnscud.cavedemo.web.feign.UserServiceClient;
import com.cnscud.cavedemo.web.utils.CodeMsgResponseUtils;
import com.cnscud.cavedemo.web.utils.JWTUtils;
import com.cnscud.cavedemo.web.utils.UserLoginUtils;
import com.cnscud.cavedemo.web.utils.web.RequestUtils;
import com.cnscud.xpower.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录相关操作.
 *
 * @author Felix Zhang 2021-08-06 19:53
 * @version 1.0.0
 */
@Controller
public class SignController {

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goLogin() {
        return "/signin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        //验证密码
        String username = RequestUtils.getString(request, "username", "");
        String password = RequestUtils.getString(request, "password", "");

        User user = userServiceClient.queryUserByUserName(username);

        //用户是否存在
        if (user == null) {
            return CodeMsgResponseUtils.getResultJson(MsgConstants.FAIL, "用户不存在");
        }

        //密码是否正确
        if (!user.getPassword().equals(UserLoginUtils.shadowPassword(user.getSalt(), password))) {
            return CodeMsgResponseUtils.getResultJson(MsgConstants.FAIL, "用户密码错误");
        }

        //生成token
        String token = JWTUtils.sign(user.getId(), MsgConstants.Token_Level);

        //设置cookie
        CookieUtils.setCookie(response, MsgConstants.Cookie_LoginToken, token, MsgConstants.Cookie_Domain, MsgConstants.Cookie_Path, MsgConstants.EXPIRE_TIME);

        //json: success
        return CodeMsgResponseUtils.getSuccessResultJson();
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        //清理token, 转向首页

        User user = (User) request.getAttribute(MsgConstants.CURRENT_USER_ATTRIBUTE);
        if (user != null) {

            JWTUtils.signout(user.getId());

            CookieUtils.deleteCookie(response, CookieUtils.getCookie(request, MsgConstants.Cookie_LoginToken), MsgConstants.Cookie_Domain, MsgConstants.Cookie_Path);
        }
        return "redirect:/";
    }

}
