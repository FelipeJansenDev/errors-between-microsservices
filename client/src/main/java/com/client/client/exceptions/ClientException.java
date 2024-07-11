package com.client.client.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public class ClientException extends RuntimeException {

    private final HttpStatusCode httpStatusCode;
    private final String code;

    public ClientExceptionBody getOnlyBody() {
        return ClientExceptionBody.builder()
                .code(this.code)
                .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ClientExceptionBody {
        private String code;
    }
}
