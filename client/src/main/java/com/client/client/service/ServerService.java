package com.client.client.service;

import com.client.client.exceptions.ClientException;
import com.client.client.model.Sucesso;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.rmi.ServerException;
import java.util.Objects;

@Service
public class ServerService {

    public static final String CODE = "CODE";
    private final RestClient restClient;

    public ServerService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Sucesso testMethod(Long id) {
        return restClient
                .get()
                .uri("http://localhost:8080?id=" + id)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (HttpRequest request, ClientHttpResponse response) -> {
                    throw new ClientException(HttpStatus.BAD_REQUEST, Objects.requireNonNull(response.getHeaders().get(CODE)).get(0));
                })
                .body(Sucesso.class);
    }
}

