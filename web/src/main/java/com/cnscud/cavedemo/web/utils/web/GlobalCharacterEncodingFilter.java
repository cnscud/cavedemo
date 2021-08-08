package com.cnscud.cavedemo.web.utils.web;

import org.springframework.util.ClassUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Global CharacterEncodingFilter
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2012-11-19
 */
public class GlobalCharacterEncodingFilter extends OncePerRequestFilter {

    static final Pattern inputPattern = Pattern.compile(".*_input_encode=([\\w-]+).*");

    static final Pattern outputPattern = Pattern.compile(".*_output_encode=([\\w-]+).*");

    // Determine whether the Servlet 2.4 HttpServletResponse.setCharacterEncoding(String)
    // method is available, for use in the "doFilterInternal" implementation.
    private final static boolean responseSetCharacterEncodingAvailable = ClassUtils.hasMethod(HttpServletResponse.class, "setCharacterEncoding",
            new Class[] { String.class });

    private String encoding = "UTF-8";

    private boolean forceEncoding = true;
    private Pattern whitelist = null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (whitelist != null && whitelist.matcher(uri).matches()) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            doSetEncoding(request, response);
        } catch (UnsupportedEncodingException uee) {
            response.sendError(406);
            return;
        }
        dispatch(request, response, filterChain);
    }

    protected void doSetEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String url = request.getQueryString();

        Matcher m = null;
        if (url != null && (m = inputPattern.matcher(url)).matches()) {
            String inputEncoding = m.group(1);
            request.setCharacterEncoding(inputEncoding);
            m = outputPattern.matcher(url);
            if (m.matches()) {
                response.setCharacterEncoding(m.group(1));
            } else {
                if (this.forceEncoding && responseSetCharacterEncodingAvailable) {
                    response.setCharacterEncoding(this.encoding);
                }
            }
        } else {
            if (this.encoding != null && (this.forceEncoding || request.getCharacterEncoding() == null)) {
                request.setCharacterEncoding(this.encoding);
                if (this.forceEncoding && responseSetCharacterEncodingAvailable) {
                    response.setCharacterEncoding(this.encoding);
                }
            }
        }
    }

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(request, response);
    }

    /**
     * Set the encoding to use for requests. This encoding will be passed into a {@link HttpServletRequest#setCharacterEncoding} call.
     * <p>
     * Whether this encoding will override existing request encodings (and whether it will be applied as default response encoding as well) depends on the
     * {@link #setForceEncoding "forceEncoding"} flag.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Set whether the configured {@link #setEncoding encoding} of this filter is supposed to override existing request and response encodings.
     * <p>
     * Default is "false", i.e. do not modify the encoding if {@link HttpServletRequest#getCharacterEncoding()} returns a non-null value.
     * Switch this to "true" to enforce the specified encoding in any case, applying it as default response encoding as well.
     * <p>
     * Note that the response encoding will only be set on Servlet 2.4+ containers, since Servlet 2.3 did not provide a facility for setting a default response
     * encoding.
     */
    public void setForceEncoding(boolean forceEncoding) {
        this.forceEncoding = forceEncoding;
    }

    public void setWhitelist(String whitelist) {
        if (whitelist != null && whitelist.length() > 0) {
            this.whitelist = Pattern.compile(whitelist);
        }
    }

    @Override
    protected String getAlreadyFilteredAttributeName() {
        return "SucCharacterEncodingFilter.FILTERED";
    }
}