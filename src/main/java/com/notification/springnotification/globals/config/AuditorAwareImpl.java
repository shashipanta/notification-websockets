package com.notification.springnotification.globals.config;

import com.notification.springnotification.authentication.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/16/23 6:26 PM
 */
@Component
@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<Long> {


    private final UserRepository userRepository;

    private static final String ANONYMOUS_USER = "anonymousUser";

    @Override
    public Optional<Long> getCurrentAuditor() {
        // check current user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long loggedUser = 0l;

        if(ANONYMOUS_USER.equals(authentication.getName())) {
            System.out.println("annonymous user");
        } else {
            System.out.println(authentication.getPrincipal());
            loggedUser = userRepository.findByUserName(authentication.getName());
        }
        return Optional.of(loggedUser);
    }

}
