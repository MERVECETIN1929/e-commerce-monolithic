package com.example.ecommercemono2.common.exception;

import org.springframework.stereotype.Service;


public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
