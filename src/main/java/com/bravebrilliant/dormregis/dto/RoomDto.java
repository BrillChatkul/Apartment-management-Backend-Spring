package com.bravebrilliant.dormregis.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    @NotNull(message = "roomNo is mandatory")
    @NotBlank(message = "roomNo must not be empty")
    @Size(max = 10, message = "roomNo length must less than 10")
    private String roomNo;

    @Min(value = 1, message = "cost number must be greater than zero")
    private int cost;
    private String detail;
}
