package com.example.demo;

import org.springframework.web.bind.annotation.ResponseStatus;

public class UnProcessableException extends RuntimeException {
    public UnProcessableException(String message) {
        super(message);
    }
}
