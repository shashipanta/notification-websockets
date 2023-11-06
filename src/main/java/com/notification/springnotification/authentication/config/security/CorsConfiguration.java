package com.notification.springnotification.authentication.config.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/6/23 9:18 PM
 */
@Configuration
public class CorsConfiguration {

    private static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
    private static final String[] ALLOWED_HEADERS = {"Content-Type", "x-request-with"};
    private static final int MAX_AGE = 3600;

    private static final String ALLOWED_ORIGIN = "http://localhost:8080";

    @Value("$cors.allowed-origins")
    private String allowedOrigin;

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("*/*")
                        .allowedOrigins(allowedOrigin)
                        .allowedHeaders(ALLOWED_HEADERS)
                        .allowedMethods(ALLOWED_METHODS)
                        .maxAge(MAX_AGE);
            }
        };
    }
}
