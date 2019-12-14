package com.github.egnaf.spring_docker_example.rest.error;

import lombok.Data;

@Data
class ErrorResponse {
    private int status;
    private String message;

    ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
