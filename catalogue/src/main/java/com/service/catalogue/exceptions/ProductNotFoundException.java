package com.service.catalogue.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " not found");
    }
}

