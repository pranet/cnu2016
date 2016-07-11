package com.cnu2016.nagarwal.helpers;

import com.cnu2016.nagarwal.controller.ModifiedInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by niteshagarwal002 on 11/07/16.
 */
@Configuration
public class AnnotationSecurityConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ModifiedInterceptor());
    }
}
