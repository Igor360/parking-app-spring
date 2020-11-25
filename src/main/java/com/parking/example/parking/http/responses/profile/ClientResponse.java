package com.parking.example.parking.http.responses.profile;

import lombok.Getter;
import lombok.Setter;

public class ClientResponse {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String docNumber;

    @Getter
    @Setter
    private String phone;
}
