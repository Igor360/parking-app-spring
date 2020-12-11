package com.parking.example.parking.http.responses.client;

import com.parking.example.parking.http.responses.profile.ClientResponse;
import com.parking.example.parking.models.Car;
import com.parking.example.parking.models.Client;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class CarResponse implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String vinCode;
}
