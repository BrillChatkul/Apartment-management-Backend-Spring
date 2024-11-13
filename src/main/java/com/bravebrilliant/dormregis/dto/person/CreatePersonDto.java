package com.bravebrilliant.dormregis.dto.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePersonDto {

    @NotNull(message = "firstName is mandatory")
    @NotBlank(message = "firstName must not be empty")
    private String firstName;

    private String roomNo;
}
