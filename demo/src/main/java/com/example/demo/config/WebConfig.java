package com.example.demo.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:63342"); // 允许的来源
        config.addAllowedMethod("*"); // 允许的HTTP方法
        config.addAllowedHeader("*"); // 允许的请求头
        config.setAllowCredentials(true); // 允许凭证

        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*")
                .allowedHeaders("*").allowCredentials(config.getAllowCredentials());
    }
}
