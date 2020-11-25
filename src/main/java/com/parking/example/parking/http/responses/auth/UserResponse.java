package com.parking.example.parking.http.responses.auth;

import lombok.Getter;
import lombok.Setter;

public class UserResponse {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

    public UserResponse(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
