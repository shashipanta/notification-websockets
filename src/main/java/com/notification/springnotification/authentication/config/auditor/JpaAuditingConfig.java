package com.notification.springnotification.authentication.config.auditor;

import com.notification.springnotification.authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 7:01 PM
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@RequiredArgsConstructor
public class JpaAuditingConfig {

    private final AuthService authService;

    private static final String ANONYMOUS_USER = "anonymousUser";

    /**
     * <h1>Get logged In userId for Auditing purpose</h1>
     *
     * @return 0 if user is anonymous and <code>userId</code> if user is loggedIn
     */
    @Bean
    protected AuditorAware<Long> auditorProvider() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Long loggedUserId;
            if (ANONYMOUS_USER.equals(authentication.getName())) {
                loggedUserId = 0L;
            } else {
                loggedUserId = authService.getUserIdFromEmail(authentication.getName());
            }
            return Optional.of(loggedUserId);
        };

    }
}
