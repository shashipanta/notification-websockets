package com.notification.springnotification.authentication.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 12:34 AM
 */
@Configuration
public class SecurityHelper {

    /**
     * Create Beans required for spring security
     * {@code PasswordEncoder} Password encoder for encoding and decoding password
     */

    @Bean
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
