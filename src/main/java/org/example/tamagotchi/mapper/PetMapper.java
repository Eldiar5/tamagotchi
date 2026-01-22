package org.example.tamagotchi.mapper;

import org.example.tamagotchi.dto.response.PetResponseDto;
import org.example.tamagotchi.entity.Pet;

public interface PetMapper {

    PetResponseDto dtoEnrichment(Pet source);

}
