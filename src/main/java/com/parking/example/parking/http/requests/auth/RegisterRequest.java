package com.parking.example.parking.http.requests.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {

    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 50)
    @Email
    @Pattern(regexp = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+.[a-zA-Z]{2,4}S")
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Size(min = 6, max = 40)
    @Pattern(regexp = "^(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    private String password;

}
