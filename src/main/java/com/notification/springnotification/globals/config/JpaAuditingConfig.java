package com.notification.springnotification.globals.config;

import com.notification.springnotification.authentication.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/17/23 12:59 AM
 */

@Configuration
@RequiredArgsConstructor
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

    private final UserRepository userRepository;

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new AuditorAwareImpl(userRepository);
    }
}
