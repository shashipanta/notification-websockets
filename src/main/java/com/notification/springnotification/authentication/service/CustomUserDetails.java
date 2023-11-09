package com.notification.springnotification.authentication.service;

import com.notification.springnotification.authentication.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 12:08 AM
 */
public class CustomUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final Boolean accountNonExpired;
    private final Boolean accountNonLocked;
    private final Boolean credentialNonExpired;
    private final Boolean enabled;

    public CustomUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.grantedAuthorities = Set.of(new SimpleGrantedAuthority("Admin"));
        this.accountNonExpired = user.getAccountNonExpired();
        this.accountNonLocked = user.getAccountNonLocked();
        this.credentialNonExpired = user.getAccountNonExpired();
        this.enabled = user.getEnabled();
    }

    private final Set<GrantedAuthority> grantedAuthorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
