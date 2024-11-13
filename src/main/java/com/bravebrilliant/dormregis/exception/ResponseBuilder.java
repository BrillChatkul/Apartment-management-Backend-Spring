package com.bravebrilliant.dormregis.exception;

import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    private ResponseBuilder() throws IllegalAccessException {
        throw new IllegalAccessException("ResponseBuilder cannot be created");
    };

    public static ResponseEntity<Object> build(ApiError apiError){
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
