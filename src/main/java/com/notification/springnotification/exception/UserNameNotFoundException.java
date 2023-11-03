package com.notification.springnotification.exception;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 12:22 AM
 */
public class UserNameNotFoundException extends RuntimeException{

    public UserNameNotFoundException(String message) {
        super(message);
    }
}
