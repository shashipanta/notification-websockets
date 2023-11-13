package com.notification.springnotification.globals;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:33 PM
 */

@Getter
@Setter
@Builder
public class GlobalApiResponse {

    private String message;
    private Object data;
    private String messageCode;
}
