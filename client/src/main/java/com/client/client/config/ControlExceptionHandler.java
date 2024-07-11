package com.client.client.config;

import com.client.client.exceptions.ClientException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControlExceptionHandler {

    @ExceptionHandler({ClientException.class})
    public ResponseEntity<Object> serverException(ClientException e) {
        return ResponseEntity.status(e.getHttpStatusCode()).body(e.getOnlyBody());
    }

}



