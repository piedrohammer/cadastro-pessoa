package com.example.cadastro_api.core.exceptions;

public class CpfCnpjNotFoundException extends RuntimeException {
    public CpfCnpjNotFoundException(String message) {
        super(message);
    }
}

