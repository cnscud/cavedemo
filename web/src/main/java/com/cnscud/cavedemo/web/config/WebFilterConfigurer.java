package com.cnscud.cavedemo.web.config;

import com.cnscud.cavedemo.web.utils.web.GlobalSystemFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configurer.
 *
 * @author Felix Zhang 2021-08-07 21:14
 * @version 1.0.0
 */
@Configuration
public class WebFilterConfigurer {


    @Bean
    public FilterRegistrationBean<GlobalSystemFilter> declareFilterRegistration() {
        FilterRegistrationBean<GlobalSystemFilter> registration = new FilterRegistrationBean<>(new GlobalSystemFilter());
        registration.addUrlPatterns("/*");
        registration.setName("myFilter");
        return registration;
    }
}
