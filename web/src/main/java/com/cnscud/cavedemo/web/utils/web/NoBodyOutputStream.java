package com.cnscud.cavedemo.web.utils.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

/**
 * 处理无BODY的响应，例如：HEAD方法
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2013年7月29日
 * @see {@linkplain http://axelfontaine.com/blog/http-head.html}
 */
class NoBodyOutputStream extends ServletOutputStream {
    private int contentLength = 0;

    int getContentLength() {
        return contentLength;
    }

    public void write(int b) {
        contentLength++;
    }

    public void write(byte buf[], int offset, int len) throws IOException {
        contentLength += len;
    }
    //@Override
    public boolean isReady() {
        return true;
    }
    //@Override
    public void setWriteListener(WriteListener writeListener) {
    }
}