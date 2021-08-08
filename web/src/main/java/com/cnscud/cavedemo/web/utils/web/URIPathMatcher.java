package com.cnscud.cavedemo.web.utils.web;

import org.springframework.util.AntPathMatcher;

import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * URI Path Matcher.
 * 
 * @author Felix Zhang Date 2013-05-23 16:05
 * @version 1.0.0
 */
public class URIPathMatcher extends AntPathMatcher {

    public boolean extractUriTemplateVariables(String pattern, String path, Map<String, String> variables) {
        return doMatch(pattern, path, true, variables);
    }

    /**
     * 解析URI为模板变量.
     * 
     * @param uri
     *            要解析的URI
     * @param rules
     *            解析规则, 参见Spring的RequestMapping
     * @return 解析结果的map, 如果为空说明没有匹配成功
     */
    public Map<String, String> parseURI(String uri, String[] rules) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (String rule : rules) {
            boolean result = extractUriTemplateVariables(rule, uri, map);
            if (result) {
                break;
            }
        }

        try {
            for (Map.Entry<String, String> e : map.entrySet()) {
                e.setValue(URLDecoder.decode(e.getValue(), "UTF-8"));
            }
        } catch (Exception e) {
            // do nothing
        }

        return map;
    }

}
