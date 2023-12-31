package com.notification.springnotification.global;

import lombok.Builder;
import lombok.Data;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 1:13 AM
 */

@Builder
public class GlobalApiResponse {

    private String message;
    private Object data;
    private String statusCode;
}
