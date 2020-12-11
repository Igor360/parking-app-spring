package com.parking.example.parking.http.requests.client;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ClientAccountRequest implements Serializable {

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
