package com.notification.springnotification.authentication.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/3/23 10:31 PM
 */

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    private static final String SECURITY_BASE_URL = "/api/v1/auth";

    private static final String LOGIN_URL = SECURITY_BASE_URL + "/login";
    private static final String REGISTRATION_URL = SECURITY_BASE_URL + "/register";
    private static final String LOGOUT_URL = SECURITY_BASE_URL + "/logout";
    private static final String LOGIN_FAILURE_URL = LOGIN_URL + "?error";
    private static final String DEFAULT_SUCCESS_URL = SECURITY_BASE_URL + "/home";
    private static final String USERNAME_PARAMETER = "Username";
    private static final String PASSWORD_PARAMETER = "Password";

    private static final String EXPIRED_SESSION_URL = SECURITY_BASE_URL + "/expired";

    private static final String[] WHITELISTED_URLS = {
            LOGIN_URL,
            REGISTRATION_URL
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authenticationProvider(getDaoAuthenticationProvider());

        // disable csrf token
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.cors(Customizer.withDefaults());

//        httpSecurity.cors(httpSecurityCorsConfigurer ->
//                httpSecurityCorsConfigurer.configure(httpSecurity)
//        );

        // enable form login
        httpSecurity
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl(LOGIN_URL)
                        .failureUrl(LOGIN_FAILURE_URL)
                        .defaultSuccessUrl(DEFAULT_SUCCESS_URL)
                        .usernameParameter(USERNAME_PARAMETER)
                        .passwordParameter(PASSWORD_PARAMETER)
                )
                .logout(logout -> logout
                        .logoutUrl(LOGOUT_URL)
                        .invalidateHttpSession(true)
                        .deleteCookies("JESSIONID")
                        .logoutSuccessUrl(LOGOUT_URL + "?logout")
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .maximumSessions(2)
                        .expiredUrl(EXPIRED_SESSION_URL)
                        .maxSessionsPreventsLogin(true)
                );

        // path mathcing
        httpSecurity
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/api/v1/products/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                );

        return httpSecurity.build();
    }

    private DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider =  new DaoAuthenticationProvider(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }


}
