package com.hungjava.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**") // Áp dụng cho tất cả API bắt đầu bằng /api/v1/
                .allowedOrigins("http://localhost:5173") // Chỉ cho phép FE này
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Chỉ cho phép các phương thức này
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
