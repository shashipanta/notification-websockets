package com.notification.springnotification.authentication.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/6/23 9:18 PM
 */
@Configuration
public class CorsConfiguration {

    private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN";
    private static final String ALLOWED_METHODS = "GET, PUT, POST, DELETE, OPTIONS";
    private static final Long MAX_AGE = 3600L;

    private static final String ALLOWED_ORIGIN = "http://localhost:5173";

    @Value("${cors.allowed-origins}")
    private String allowedOrigin;

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins(ALLOWED_ORIGIN)
                        .allowedHeaders(ALLOWED_HEADERS)
                        .allowedMethods(ALLOWED_METHODS)
                        .exposedHeaders(ALLOWED_HEADERS)
                        .maxAge(MAX_AGE);
            }
        };
    }
}
