package com.cnscud.cavedemo.web.utils.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 处理无BODY的响应，例如：HEAD方法
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2013年7月29日
 * @see {@linkplain http://axelfontaine.com/blog/http-head.html}
 */
class NoBodyResponseWrapper extends HttpServletResponseWrapper {
    private final NoBodyOutputStream noBodyOutputStream = new NoBodyOutputStream();
    private PrintWriter writer;

    public NoBodyResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return noBodyOutputStream;
    }

    public PrintWriter getWriter() throws UnsupportedEncodingException {
        if (writer == null) {
            writer = new PrintWriter(new OutputStreamWriter(noBodyOutputStream, getCharacterEncoding()));
        }

        return writer;
    }

    void setContentLength() {
        super.setContentLength(noBodyOutputStream.getContentLength());
    }
}