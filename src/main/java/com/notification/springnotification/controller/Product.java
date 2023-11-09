package com.notification.springnotification.controller;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/9/23 1:25 AM
 */

@Getter
@Setter
@Builder
public class Product {

    private String name;
    private String nameNp;
}
