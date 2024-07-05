package com.server.server.config;

import com.server.server.exceptions.ServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControlExceptionHandler {

    public static final String CODE = "CODE";

    @ExceptionHandler({ServerException.class})
    public ResponseEntity<Object> serverException(ServerException e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CODE, e.getCode());
        return ResponseEntity.status(e.getHttpStatusCode()).headers(responseHeaders).build();
    }

}



