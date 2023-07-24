package com.ibc.backend.negocio.utils.exception;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;


public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    
    @Getter
    private Map<String, String> errors = new HashMap<>();

    public BadRequestException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}
