package com.parking.example.parking.http.requests.client;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreateCarRequest implements Serializable {

    @Getter
    @Setter
    @NotEmpty(message = "Please provide name")
    @Size(max = 60)
    private String name;

    @Getter
    @Setter
    @NotEmpty(message = "Please provide car type")
    @Size(max = 60)
    private String type;

    @Getter
    @Setter
    @NotEmpty(message = "Please provide car vin code")
    @Size(max = 256)
    private String vinCode;
}
