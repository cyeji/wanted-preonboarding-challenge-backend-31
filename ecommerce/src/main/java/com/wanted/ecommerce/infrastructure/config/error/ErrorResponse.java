package com.wanted.ecommerce.infrastructure.config.error;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class ErrorResponse {

    private final boolean success = false;
    private final ErrorBody error;

    @Getter
    @Builder
    public static class ErrorBody {

        private String code;
        private String message;
        private Map<String, String> details;

    }

    public static ErrorResponse of(String code, String message) {
        return ErrorResponse.builder()
            .error(ErrorBody.builder()
                       .code(code)
                       .message(message)
                       .build())
            .build();
    }

    public static ErrorResponse of(String code, String message, Map<String, String> details) {
        return ErrorResponse.builder()
            .error(ErrorBody.builder()
                       .code(code)
                       .message(message)
                       .details(details)
                       .build())
            .build();
    }

}
