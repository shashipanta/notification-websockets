package com.notification.springnotification.controller;

import com.notification.springnotification.global.GlobalApiResponse;
import com.notification.springnotification.global.controller.BaseController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/9/23 1:27 AM
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

    @PostMapping
    public ResponseEntity<GlobalApiResponse> registerNewProduct(@RequestBody @Valid ProductRequest productRequest) {

        System.out.println("product request" + productRequest);

        return new ResponseEntity<>(successResponse("success", new Product("productName", "productnameNp")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse> getRegisteredProducts(@RequestParam(value = "isActive", required = false) Long isActive) {

        List<String> products = List.of("Product1", "Product2", "Product3", "Product4");

        return new ResponseEntity<>(successResponse("success", products), HttpStatus.OK);
    }
}
