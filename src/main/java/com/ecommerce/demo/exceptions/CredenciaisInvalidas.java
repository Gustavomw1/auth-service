package com.ecommerce.demo.exceptions;

public class CredenciaisInvalidas extends RuntimeException {
    public CredenciaisInvalidas(String message) {
        super(message);
    }
}
