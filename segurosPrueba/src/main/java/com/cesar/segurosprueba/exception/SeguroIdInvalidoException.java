package com.cesar.segurosprueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeguroIdInvalidoException extends RuntimeException {
    public SeguroIdInvalidoException(String message) {
        super(message);
    }
}
