package com.cnscud.cavedemo.web.utils.web;



import com.cnscud.xpower.utils.DateTimeUtils;
import com.cnscud.xpower.utils.IpAddressUtils;
import com.cnscud.xpower.utils.JsonUtils;
import com.cnscud.xpower.utils.PidUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Servlet操作类
 * 
 * @author Ady Liu (imxylz@gmail.com)
 * @since 2012-11-19
 */
public class RequestUtils {

    public static final String ENCODING = "UTF-8";
    public static final long EXPIRED_TIME = 1350264600000L;

    /**
     * 获取request中，类型为Boolean的key的值，支持"true/1/on"。
     * 
     * @param request
     *            需要解析的HttpServletRequest
     * @param key
     *            需要取出的属性名
     * @param defaultValue
     *            设置默认值
     * @return Boolean类型的属性值
     * @author Ady Liu (imxylz@gmail.com)
     * @since 2013/7/30
     */
    public static boolean getBoolean(HttpServletRequest request, String key, boolean defaultValue) {
        return ParamUtils.getBoolean(request.getParameter(key), defaultValue);
    }

    /**
     * 获取request中，类型为Short的key的值
     * 
     * @param request
     *            需要解析的HttpServletRequest
     * @param key
     *            需要取出的属性名
     * @param defaultValue
     *            设置默认值
     * @return Short类型的属性值
     */
    public static short getShort(HttpServletRequest request, String key, short defaultValue) {
        String str = request.getParameter(key);
        return ParamUtils.getShort(str, defaultValue);
    }

    /**
     * 获取request中，类型为Int的key的值
     * 
     * @param request
     *            需要解析的HttpServletRequest
     * @param key
     *            需要取出的属性名
     * @param defaultValue
     *            设置默认值
     * @return Int类型的属性值
     */
    public static int getInt(HttpServletRequest request, String key, int defaultValue) {
        String str = request.getParameter(key);
        return ParamUtils.getInt(str, defaultValue);
    }

    /**
     * 获取request中，类型为Long的key的值
     * 
     * @param request
     *            需要解析的HttpServletRequest
     * @param key
     *            需要取出的属性名
     * @param defaultValue
     *            设置默认值
     * @return Long类型的属性值
     */
    public static long getLong(HttpServletRequest request, String key, long defaultValue) {
        String str = request.getParameter(key);
        return ParamUtils.getLong(str, defaultValue);
    }

    public static double getDouble(HttpServletRequest request, String key, double defaultValue) {
        String str = request.getParameter(key);
        return ParamUtils.getDouble(str, defaultValue);
    }

    /**
     * 获取request中，类型为String的key的值
     * 
     * @param request
     *            需要解析的HttpServletRequest
     * @param key
     *            需要取出的属性名
     * @param defaultValue
     *            设置默认值
     * @return String类型的属性值
     */
    public static String getString(HttpServletRequest request, String key, String defaultValue) {
        String str = request.getParameter(key);
        return ParamUtils.getString(str, defaultValue);
    }

    /**
     * 获取request中，类型为String的key，如果传入的值不在合法值集合中，则返回默认值
     * 
     * @param request
     *            需要解析的HttpServletRequest
     * @param key
     *            需要取出的属性名
     * @param validValues
     *            合法值
     * @param defaultValue
     *            设置默认值
     * @return String类型的属性值
     */
    public static String getString(HttpServletRequest request, String key, String[] validValues, String defaultValue) {
        boolean caseSensitive = false;
        return getString(request, key, validValues, defaultValue, caseSensitive);
    }

    /**
     * 获取request中，类型为String的key，如果传入的值不在合法值集合中，则返回默认值
     * 
     * @param request
     *            需要解析的HttpServletRequest
     * @param key
     *            需要取出的属性名
     * @param validValues
     *            可以使用的值
     * @param defaultValue
     *            合法值
     * @param caseSensitive
     *            大小写是否敏感
     * @return String类型的属性值
     */
    public static String getString(HttpServletRequest request, String key, String[] validValues, String defaultValue, boolean caseSensitive) {
        String str = request.getParameter(key);
        return ParamUtils.getString(str, validValues, defaultValue, caseSensitive);
    }
    
    public static LocalDate getLocalDate(HttpServletRequest request, String key, LocalDate defaultValue) {
        return DateTimeUtils.toLocalDate(getString(request, key, null), defaultValue);
    }
    public static LocalDateTime getLocalDateTime(HttpServletRequest request, String key, LocalDateTime defaultValue) {
        LocalDateTime t = DateTimeUtils.toLocalDateTime(getString(request, key, null));
        return t == null ? defaultValue : t;
    }
    public static YearMonth getYearMonth(HttpServletRequest request, String key, YearMonth defaultValue) {
        return DateTimeUtils.toYearMonth(getString(request, key, null), defaultValue);
    }

    /**
     * 设置缓存过期时间
     * 
     * @param response
     *            响应头
     * @param unit
     *            时间单元
     * @param time
     *            过期时间
     */
    public static void setCacheHeader(HttpServletResponse response, TimeUnit unit, long time) {
        response.setHeader("Pragma", "Public");
        // HTTP 1.1
        response.setHeader("Cache-Control", "max-age=" + unit.toSeconds(time));
        response.setDateHeader("Expires", System.currentTimeMillis() + unit.toMillis(time));
    }

    /**
     * 设置过期时间，增加CDN和浏览器缓存策略
     * 
     * @param response
     *            响应头
     * @param time
     *            过期时间，单位秒
     */
    public static void setCacheHeader(HttpServletResponse response, long time) {
        setCacheHeader(response, TimeUnit.SECONDS, time);
    }

    /**
     * 设置Response头，加入no-cache属性
     * <p>
     * 对于HTTP头HEADER会作如下处理：
     * <ul>
     * <li>Expires: 0</li>
     * <li>RHOST: 后端IP地址信息 {@link IpAddressUtils#getAllLocalSiteAddress()}</li>
     * <li>Cache-Control: no-cache</li>
     * <li>Pragma: no-cache</li>
     * </ul>
     * </p>
     * 
     * @param response
     *            响应头
     */
    public static void setNoCacheHeader(HttpServletResponse response) {
        if (!response.containsHeader("Expires")) {
            response.setDateHeader("Expires", EXPIRED_TIME);
        }
        if (!response.containsHeader("RHOST")) { // 如果没有写入RHOST，则写入一次
            response.setHeader("RHOST", IpAddressUtils.getAllLocalSiteAddress() + "@" + PidUtils.getPid());
        }
        // HTTP 1.1
        if (!response.containsHeader("Cache-Control")) { // 如果没有写入RHOST，则写入一次
            response.setHeader("Cache-Control", "no-cache, no-store");
        }
        if(!response.containsHeader("Access-Control-Expose-Headers")) {
            response.setHeader("Access-Control-Expose-Headers", "RHOST");
        }
    }

    private static final String callBackFormat = "%s(%s);";
    /**
     * 向Response写入数据，通常适用于写入字符串、Json数据、XML数据等，写入成功后会刷新输出流。
     * @see #writeResponse(HttpServletRequest, HttpServletResponse, String)
     */
    public static void writeJsonResponse(HttpServletRequest request, HttpServletResponse response, int code, String msg, Object data) throws IOException {
        Map<String, Object> result = new LinkedHashMap<>(3);
        result.put("code", code);
        result.put("msg", msg);
        if (data != null) {
            result.put("data", data);
        }
        writeResponse(request, response, JsonUtils.toJson2(result, false, true), "application/json");
    }

    public static void writeJsonResponse(HttpServletRequest request, HttpServletResponse response, Object data) throws IOException {
        writeResponse(request, response, JsonUtils.toJson2(data, false, true), "application/json");
    }

    /**
     * 写入JSON数据
     * @param obj 字符串
     * @throws IOException
     */
    public static void writeJsonResponse(HttpServletRequest request, HttpServletResponse response, String obj) throws IOException{
        writeResponse(request, response, obj, "application/json");
    }

    /**
     * 向Response写入数据，通常适用于写入字符串、Json数据、XML数据等，写入成功后会刷新输出流。
     * <p>
     * 此操作会写入如下信息：
     * <ol>
     * <li>如果<code>request</code>中包含参数callback=doit，则写入格式为: callback(obj.toString());</li>
     * <li>否则，写入格式为:obj.toString()</li>
     * </ol>
     * </p>
     * <p>
     * 同时对于HTTP头HEADER会作如下处理：
     * <ul>
     * <li>ContentType: text/html;charset=encoding （编码默认为UTF-8，会根据请求动态设置 {@link GlobalCharacterEncodingFilter}）</li>
     * <li>Expires: 0</li>
     * <li>RHOST: 后端IP地址信息 {@link IpAddressUtils#getAllLocalSiteAddress()}</li>
     * <li>Cache-Control: no-cache</li>
     * <li>Pragma: no-cache</li>
     * </ul>
     * </p>
     * 
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param obj
     *            要写入的对象，调用{@link Object#toString()}写入输出流
     * @throws IOException
     *             任何网络异常，IO异常
     * @author adyliu (adyliu@sohu-inc.com)
     * @see {@link GlobalCharacterEncodingFilter}
     * @see {@link IpAddressUtils#getAllLocalSiteAddress()}
     * @since 2011-8-15
     */
    public static void writeResponse(HttpServletRequest request, HttpServletResponse response, String obj) throws IOException {
        writeResponse(request, response, obj,  "text/html");
    }
    public static void writeResponse(HttpServletRequest request, HttpServletResponse response, String obj, String contentType) throws IOException {
        if (response.isCommitted()) {
            throw new IOException("Response had been commited");
        }
        boolean javascriptContentType = false;
        String callback = request.getParameter("cb");
        callback = callback == null ? request.getParameter("callback") : callback;
        final String _wt = request.getParameter("_wt");
        if(callback != null) {
            contentType = "application/javascript";
        }else if("json".equalsIgnoreCase(_wt)) {
            contentType = "application/json";
        }else if("jsonp".equalsIgnoreCase(_wt)) {
            contentType = "application/javascript";
        }else if("text".equalsIgnoreCase(_wt)) {
            contentType = "text/plain";
        }
       
        String encoding = response.getCharacterEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        response.setContentType(String.format("%s;charset=%s", contentType, encoding));
        response.setDateHeader("Expires", EXPIRED_TIME);
        if (!response.containsHeader("RHOST")) { // 如果没有写入RHOST，则写入一次
            response.setHeader("RHOST", IpAddressUtils.getAllLocalSiteAddress() + "@" + PidUtils.getPid());
        }
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        String ret;
        if (callback != null) {
            // callback = (callback);
            String value = String.valueOf(obj);// value 不能处理正常的数据，需要原始接口处理数据
            // value = HtmlUtils.removeAllTags( String.valueOf(obj));
            ret = String.format(callBackFormat, callback, value);
        } else {
            ret = String.valueOf(obj);
        }
        response.setIntHeader("Content-Length", ret.getBytes("UTF-8").length);
        response.getWriter().write(ret);
        response.getWriter().flush();// 强制Flush
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String xReq = request.getHeader("X-Requested-With");
        return (xReq != null);
    }
    /** URL是否是HTTPS请求*/
    public static boolean isSecurity(String url) {
        return url.toLowerCase().startsWith("https://");
    }
    @Deprecated
    public static String getRefer(HttpServletRequest request) {
        return request.getHeader("Referer");
    }
    public static String getReferer(HttpServletRequest request) {
        return request.getHeader("Referer");
    }
    /**
     * 获取当前请求的URL（包括schema/host/uri/querystring等)
     * @param request Http请求
     * @return 完整的URL地址（包括schema/host/uri/querystring等)
     * @since 2015年3月3日
     * @author Ady Liu (imxylz@gmail.com)
     */
    public static String getRequestURL(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        final String queryString = request.getQueryString();
        if(queryString != null) {
            url.append("?").append(request.getQueryString());
        }
        return url.toString();
    }
    
    public static String createUrl(String uri, String queryString) {
        if(queryString != null) {
            uri += uri.contains("?") ? queryString: ("?"+queryString);
        }
        return uri;
    }

    public static String encodeURL(String url) {
        try {
            return java.net.URLEncoder.encode(url, ENCODING);
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }

    public static String decodeURL(String url) {
        try {
            return java.net.URLDecoder.decode(url, ENCODING);
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }
    public static void writeCodeMsg(HttpServletRequest request, HttpServletResponse response, int code, String msg) throws IOException {
        writeResponse(request, response, toCodeMsg(code, msg));
    }
    public static String toCodeMsg(int code, String msg) {
        return JsonUtils.toJson(code, msg);
    }

    public static void prepareHttpsAttribute(HttpServletRequest req){
        String url = req.getRequestURL().toString().toLowerCase();
        String proto = req.getHeader("X-Forwarded-Proto");

        req.setAttribute("https", url.startsWith("https") || (proto!=null && proto.startsWith("https")) );
    }
    
    /**判断某个请求是否是HTTPS*/
    public static boolean isHttps(HttpServletRequest request) {
        return "https".equals(request.getScheme()) || "https".equals(request.getHeader("X-Forwarded-Proto"));
    }
    /**自动转换http地址为https*/
    public static String getHttpsUrl(HttpServletRequest request, String httpUrl) {
        if(isHttps(request) && httpUrl.startsWith("http://")) {
            httpUrl = httpUrl.replaceFirst("http://", "https://");
        }
        return httpUrl;
    }

    public static Map<String, String> getParameters(HttpServletRequest req){
        LinkedHashMap<String, String> ret = new LinkedHashMap<>();
        req.getParameterMap().forEach((key,values)->{
            ret.put(key, String.join(",", values));
        });
        return ret;
    }
}