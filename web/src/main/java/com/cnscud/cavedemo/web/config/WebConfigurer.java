package com.cnscud.cavedemo.web.config;

import com.cnscud.cavedemo.web.helper.AuthInterceptor;
import com.cnscud.cavedemo.web.utils.web.GlobalSystemFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author adyliu (imxylz@gmail.com)
 * @since 2019-09-25
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }


}
