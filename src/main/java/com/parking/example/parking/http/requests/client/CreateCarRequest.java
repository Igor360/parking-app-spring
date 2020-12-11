package com.parking.example.parking.http.requests.client;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreateCarRequest implements Serializable {

    @NotEmpty(message = "Please provide name")
    @Size(max = 60)
    private String name;

    @NotEmpty(message = "Please provide car type")
    @Size(max = 60)
    private String type;

    @NotEmpty(message = "Please provide car vin code")
    @Size(max = 256)
    private String vinCode;
}
