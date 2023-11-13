package com.notification.springnotification.authentication.dto.request;

import java.io.Serializable;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:46 PM
 */
public record UserUpdateRequest(
        Long id,
        String username,
        String email,
        String password
) implements Serializable {
}
