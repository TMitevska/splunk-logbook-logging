package com.service.cart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartServiceException extends RuntimeException {
    public CartServiceException(String message) {
        super(message);
    }
    public CartServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

