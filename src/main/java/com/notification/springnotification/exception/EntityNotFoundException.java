package com.notification.springnotification.exception;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/3/23 11:56 PM
 */
public class EntityNotFoundException extends Exception{

    EntityNotFoundException(String message) {
        super(message);
    }
}
