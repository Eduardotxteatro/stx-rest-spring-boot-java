package com.github.Eduardotxteatro.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

    public UnsuportedMathOperationException(String exception) {
        super(exception);
    }

}
