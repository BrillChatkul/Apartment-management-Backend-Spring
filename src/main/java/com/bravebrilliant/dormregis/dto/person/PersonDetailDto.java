package com.bravebrilliant.dormregis.dto.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetailDto {
    private Long id;
    private String firstName;
    private String roomId;
}
