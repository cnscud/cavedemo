package com.cnscud.cavedemo.web.utils.common;


import com.cnscud.cavedemo.web.MsgConstants;
import com.cnscud.xpower.utils.JsonUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Response in Json.
 *
 * @author Felix Zhang 2021-08-07 16:16
 * @version 1.0.0
 */
public class CodeMsgResponseUtils {


    public static Map<String, Object> getResultMap() {
        return new LinkedHashMap<String, Object>();
    }

    public static String getResultJson(int code, String msg, Object data) {
        Map<String, Object> result = getResultMap();
        result.put("code", code);
        result.put("msg", msg);
        if (data != null) {
            result.put("data", data);
        }

        return JsonUtils.toJson2(result);
    }

    public static String getResultJson(int code, String msg) {

        return getResultJson(code, msg, null);
    }

    public static String getSuccessResultJson() {
        return getResultJson(MsgConstants.SUCCESS, "success", null);
    }

    public static String getSuccessResultJson(Map<String, ?> data) {
        return getResultJson(MsgConstants.SUCCESS, "success", data);
    }

}
