package com.server.server.service;

import com.server.server.exceptions.ServerException;
import com.server.server.model.Sucesso;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.server.server.exceptions.Constants.*;

@Service
public class ServerService {

    public Sucesso testMethod(Long id) {
        if (id == 1) {
            throw new ServerException(HttpStatus.BAD_REQUEST, ERROR_001);
        } else if (id == 2) {
            throw new ServerException(HttpStatus.BAD_REQUEST, ERROR_002);
        } else if (id == 3) {
            throw new ServerException(HttpStatus.BAD_REQUEST, ERROR_003);
        }
        return Sucesso.builder().id(id).build();
    }
}

