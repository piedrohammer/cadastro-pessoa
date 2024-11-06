package com.example.cadastro_api.core.exceptions;

public class EmailError extends RuntimeException {
    public EmailError(String message) {
        super(message);
    }
}
