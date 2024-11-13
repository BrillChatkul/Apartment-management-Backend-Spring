//package com.bravebrilliant.dormregis.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@ControllerAdvice
//public class ApiExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException ex){
//        List<String> errorList = new ArrayList<>();
//        ex.getBindingResult().getFieldErrors().forEach(error->{
//            errorList.add(error.getDefaultMessage());
//        });
//        ApiError error = ApiError.builder()
//                .errors(errorList)
//                .status(HttpStatus.BAD_REQUEST)
//                .build();
//        return ResponseBuilder.build(error);
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<Object> handleRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex){
//        ApiError error = ApiError.builder()
//                .errors(Collections.singletonList(ex.getMessage()))
//                .status(HttpStatus.METHOD_NOT_ALLOWED)
//                .build();
//        return ResponseBuilder.build(error);
//    }
//
//}
