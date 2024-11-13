package com.bravebrilliant.dormregis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundStatusException extends ResponseStatusException {

    public NotFoundStatusException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
