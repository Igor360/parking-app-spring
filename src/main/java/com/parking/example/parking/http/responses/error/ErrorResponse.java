package com.parking.example.parking.http.responses.error;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {

    @Getter
    @Setter
    private String messages;

    public ErrorResponse(String messages) {
        this.messages = messages;
    }
}
