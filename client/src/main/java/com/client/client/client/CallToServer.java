package br.com.tvx.conta.internacional.bff.client;

import com.client.client.exceptions.ClientException;
import com.client.client.model.Sucesso;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

import static com.client.client.exceptions.Constants.CODE;

@Service
@AllArgsConstructor
public class CallToServer {

    private final RestClient restClient;

    public Sucesso callToServer(String uuid) {
        return restClient
                .post()
                .uri("?id=1")
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (HttpRequest request, ClientHttpResponse response) -> {
                    throw new ClientException(response.getStatusCode(),
                            Objects.requireNonNull(response.getHeaders().get(CODE)).stream().findFirst().orElse(null));
                })
                .body(Sucesso.class);
    }

}
