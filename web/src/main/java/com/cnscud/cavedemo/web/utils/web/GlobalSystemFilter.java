package com.cnscud.cavedemo.web.utils.web;

import com.cnscud.xpower.Charsets;

import com.cnscud.xpower.utils.IpAddressUtils;
import com.cnscud.xpower.utils.PidUtils;
import org.slf4j.MDC;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统Filter操作
 * <p>
 * 支持以下特性：
 * <ul>
 * <li>字符编码：系统默认使用GBK编码，如果有所不同应该使用URL地址统一处理</li>
 * <li>后端请求IP：当前运行Java进程的主机IP，是一个内网IP</li>
 * <li>Java进程的PID：当前运行的Java进程的PID</li>
 * <li>客户端真实请求IP： 用户的IP地址，这将穿透Nginx/Apache/Squid等</li>
 * </ul>
 * </p>
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2012-11-19
 */
public class GlobalSystemFilter extends GlobalCharacterEncodingFilter {
    
    private boolean handlingHeadRequest = true;
    private static final long _boottime = System.currentTimeMillis();

    public GlobalSystemFilter() {
        setForceEncoding(true);
        setEncoding(Charsets.UTF8.charset);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(logger.isDebugEnabled()) {
            //logger.debug("call GlobalSystemFilter ...");
        }

        if(! (request instanceof RemoteAddrHttpServletRequest)) {
            request = new RemoteAddrHttpServletRequest(request);
            request.setAttribute("_boottime", _boottime);
        }
        if (handlingHeadRequest && "HEAD".equalsIgnoreCase(request.getMethod())) {
            // 处理HEAD 请求: 把HEAD变成GET请求, 并且把BODY吃掉, 模拟真的HEAD请求.
            NoBodyResponseWrapper noBodyResponseWrapper = new NoBodyResponseWrapper(response);
            super.doFilterInternal(new ForceGetRequestWrapper(request), noBodyResponseWrapper, filterChain);
            noBodyResponseWrapper.setContentLength();
        } else {
            super.doFilterInternal(request, response, filterChain);
        }
    }

    @Override
    protected void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        setNoCacheHeader(response);
        super.dispatch(request, response, filterChain);
    }

    private void setNoCacheHeader(HttpServletResponse response) {
        try {
            RequestUtils.setNoCacheHeader(response);
            MDC.put("RHOST", IpAddressUtils.getAllLocalSiteAddress() + "@" + PidUtils.getPid());
        } catch (Exception e) {
            // ignore
        }
    }

    public void setHandlingHeadRequest(boolean handlingHeadRequest) {
        this.handlingHeadRequest = handlingHeadRequest;
    }
}