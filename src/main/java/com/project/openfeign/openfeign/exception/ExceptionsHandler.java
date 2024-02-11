package com.project.openfeign.openfeign.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity handleFeignException(FeignException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = "Internal server error";

        if (ex.status() >= 400 && ex.status() < 500) {
            status = HttpStatus.BAD_REQUEST;
            message = "Cep not found";
        } else if (ex.status() >= 500 && ex.status() < 600) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(status).body(message);
    }
}
