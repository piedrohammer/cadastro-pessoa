package com.example.cadastro_api.core.exceptions;

public class BusinessException extends  RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}