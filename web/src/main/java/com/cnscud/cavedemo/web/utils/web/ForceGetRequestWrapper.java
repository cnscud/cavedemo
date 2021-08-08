package com.cnscud.cavedemo.web.utils.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 强制转换HTTP 请求为GET请求
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2013年7月29日
 * @see {@linkplain http://axelfontaine.com/blog/http-head.html}
 */
class ForceGetRequestWrapper extends HttpServletRequestWrapper {
    public ForceGetRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public String getMethod() {
        return "GET";
    }
}