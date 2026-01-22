package org.example.tamagotchi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetResponseDto {

    private Long petId;
    private String petName;

    private Integer hunger;
    private Integer happiness;

    private boolean isAlive;

}
