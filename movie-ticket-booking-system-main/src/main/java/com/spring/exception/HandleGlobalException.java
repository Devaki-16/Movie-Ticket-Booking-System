package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandleGlobalException {

    @ExceptionHandler(MovieAlreadyPresent.class)
    public ResponseEntity<?> handleDuplicate(MovieAlreadyPresent ex, WebRequest request) {
        ErrorMessage error=new ErrorMessage(ex.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<?> MovieNotPresent(MovieNotFound ex, WebRequest request) {
        ErrorMessage error=new ErrorMessage(ex.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandling(Exception ex, WebRequest request) {
        ErrorMessage error=new ErrorMessage(ex.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
