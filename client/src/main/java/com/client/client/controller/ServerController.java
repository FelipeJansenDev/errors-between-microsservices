package com.client.client.controller;

import com.client.client.model.Sucesso;
import com.client.client.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ServerController {

    private final ServerService service;

    @GetMapping
    public ResponseEntity<Sucesso> test(@RequestParam Long id) {
        return new ResponseEntity<>(service.testMethod(id), HttpStatus.OK);
    }

}
