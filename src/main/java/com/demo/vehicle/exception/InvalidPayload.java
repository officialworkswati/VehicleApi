package com.demo.vehicle.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidPayload extends RuntimeException{

    private HttpStatus statusCode;
    private String errorMessage;

    public InvalidPayload(HttpStatus statusCode, String errorMessage) {
        super(String.format("%s", errorMessage));
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
