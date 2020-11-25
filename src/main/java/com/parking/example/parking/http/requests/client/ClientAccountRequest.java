package com.parking.example.parking.http.requests.client;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class ClientAccountRequest {

    @Getter
    @Setter
    @NotBlank
    private String firstName;

    @Getter
    @Setter
    @NotBlank
    private String lastName;

    @Getter
    @Setter
    @NotBlank
    private String docNumber;

    @Getter
    @Setter
    @NotBlank
    private String phone;
}
