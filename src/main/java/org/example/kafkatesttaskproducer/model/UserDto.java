package org.example.kafkatesttaskproducer.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class UserDto {

    private String id;
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 55)
    private String password;
    @NotBlank
    @Size(min = 2, max = 50)
    private String first_name;
}
