package com.sshyuny.roadiary.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sshyuny.roadiary.config.ApiLoginInterceptor;
import com.sshyuny.roadiary.config.PageLoginInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    PageLoginInterceptor loginInterceptor;
    @Autowired
    ApiLoginInterceptor apiLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoginInterceptor)
            .order(0)
            .addPathPatterns("/api/**");
            
        registry.addInterceptor(loginInterceptor)
            .order(1)
            .addPathPatterns("/**")
            .excludePathPatterns("/", "/login", "/error");
    }
    
}
