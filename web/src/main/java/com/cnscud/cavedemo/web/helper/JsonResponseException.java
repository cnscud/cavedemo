/**
 * 
 */
package com.cnscud.cavedemo.web.helper;



import com.cnscud.xpower.utils.JsonUtils;

import java.io.IOException;

/**
 * Ajax的json结果异常封装，Controller中抛出此异常，自动以文本形式(txt)返回响应结果
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2014年1月6日
 */
public class JsonResponseException extends IOException {

    final Object messageObject;
    private int code = -1;

    public JsonResponseException(int code, String message) {
        super(message);
        this.code = code;
        this.messageObject= JsonUtils.toJson(code, message);
    }

    private JsonResponseException(Object message) {
        super(String.valueOf(message));
        this.messageObject = message;
    }

    private JsonResponseException(Object message, Throwable cause) {
        super(String.valueOf(message), cause);
        this.messageObject = message;
    }

    public Object getMessageObject() {
        return this.messageObject;
    }
    public int getCode() {
        return code;
    }

    public String toJson() throws Exception {
        if (messageObject == null) {
            return "";
        }
        if (messageObject instanceof CharSequence) {
            return ((CharSequence) messageObject).toString();
        }
        return JsonUtils.toJson(messageObject);
    }

    public static void create(int code, String message) throws JsonResponseException {
        throw new JsonResponseException(code, message);
    }
    public static void check(boolean condition,int code, String message) throws JsonResponseException {
        if(condition) {
            create(code, message);
        }
    }
}
