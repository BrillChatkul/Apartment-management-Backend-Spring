package com.bravebrilliant.dormregis.exception;

import jakarta.validation.ValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<String>> handleInvalidArgument(MethodArgumentNotValidException ex){
        List<String> errorMap = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.add(error.getDefaultMessage());
        });
        return Map.ofEntries(Map.entry("errors", errorMap));
    }

    @ExceptionHandler(ValidationException.class)
    public Map<String, Object> handleInvalidValidation(ValidationException ex){
        return Map.ofEntries(
                Map.entry("errors", ex.getMessage())
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Map<String, Object> handleInvalidTypeMismatch(MethodArgumentTypeMismatchException ex){
        return Map.ofEntries(
                Map.entry("errors", String.format("%s is missing type", ex.getName() ))
        );
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Map<String, Object> handleInvalidResponseStatus(ResponseStatusException ex){
        return Map.ofEntries(
                Map.entry("errors", Objects.requireNonNull(ex.getReason()))
        );
    }
}
