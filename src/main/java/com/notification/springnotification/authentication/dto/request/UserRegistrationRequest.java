package com.notification.springnotification.authentication.dto.request;

import java.io.Serializable;

/**
 * DTO for {@link com.notification.springnotification.authentication.model.User}
 */
public record UserRegistrationRequest(String email, String password, String userName) implements Serializable {
}