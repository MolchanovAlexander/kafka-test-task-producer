package org.example.kafkatesttaskproducer.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FindUserDto {
    @NotNull
    @Size(min = 36, max = 36)
    private String uuidRequest;
}
