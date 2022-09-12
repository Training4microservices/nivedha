package com.training.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InsufficientSalaryException extends RuntimeException {

    public InsufficientSalaryException(String exception) {
        super(exception);
    }

}
