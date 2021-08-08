package com.cnscud.cavedemo.web.utils.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * 包装ServletRequest，支持后端代理IP
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2012-11-19
 */
public class RemoteAddrHttpServletRequest extends HttpServletRequestWrapper {

    final Logger logger = LoggerFactory.getLogger(RemoteAddrHttpServletRequest.class);

    final String ipLogFormat = "X-Real-IP|X-Forwarded-For|Proxy-Client-IP|WL-Proxy-Client-IP|RemoteAddr: %s|%s|%s|%s";

    public RemoteAddrHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getRemoteAddr() {
        HttpServletRequest request = (HttpServletRequest) getRequest();
        String ip = (String) request.getAttribute("__remote_addr");
        if (ip == null) {
            ip = getRemoteAddr0(request);
            request.setAttribute("__remote_addr", ip);
        }
        return ip;
    }

    public String getRemoteAddr0(HttpServletRequest request) {

        if (request instanceof RemoteAddrHttpServletRequest) {
            request = (HttpServletRequest) ((RemoteAddrHttpServletRequest) request).getRequest();
        }
        if (logger.isDebugEnabled()) {
            logger.debug(String.format(ipLogFormat, //
                    request.getHeader("X-Real-IP"),//
                    request.getHeader("X-Forwarded-For"),//
                    request.getHeader("Proxy-Client-IP"),//
                    request.getHeader("WL-Proxy-Client-IP"),//
                    request.getRemoteAddr()));
        }
        String ip;
        ip = request.getHeader("X-Real-IP");
        if (isValidIP(ip)) {
            return ip;
        }
        Enumeration<String> xffs = request.getHeaders("X-Forwarded-For");
        if (xffs.hasMoreElements()) {
            ip = xffs.nextElement();
            String[] ips = ip.split(",");
            for (int i = 0; i < ips.length; i++) {
                ip = ips[i].trim();
                if (isValidIP(ip)) {
                    return ip;
                }
            }
        }
        ip = request.getHeader("Proxy-Client-IP");
        if (isValidIP(ip)) {
            return ip;
        }
        ip = request.getHeader("WL-Proxy-Client-IP");
        if (isValidIP(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    private static final Pattern ipPattern = Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}");

    private boolean isValidIP(String ip) {
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            return false;
        }
        return ipPattern.matcher(ip).matches();
    }
}