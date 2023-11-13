package com.notification.springnotification.authentication.dto.response;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:49 PM
 */
public record UserResponse(
        Long userId,
        String userName,
        String email,
        Boolean enabled,
        Boolean accountNonExpired) {
}
