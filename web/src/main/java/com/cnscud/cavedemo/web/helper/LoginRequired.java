package com.cnscud.cavedemo.web.helper;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface LoginRequired {
    /**
     * 是否需要登录，默认情况下需要，如果某一个方法不需要可以将此值设置为false
     * @return 是否需要登录
     */
    boolean value() default true;

    /**
     * 设置校验权限的参数名（从HttpServletRequest中获取），如果有此参数，则跳过权限验证阶段
     * @return
     */
    String secret() default "";
}
