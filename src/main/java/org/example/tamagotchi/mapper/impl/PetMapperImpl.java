package org.example.tamagotchi.mapper.impl;

import org.example.tamagotchi.dto.response.PetResponseDto;
import org.example.tamagotchi.entity.Pet;
import org.example.tamagotchi.mapper.PetMapper;
import org.springframework.stereotype.Component;

@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public PetResponseDto dtoEnrichment(Pet source) {
        PetResponseDto dto = new PetResponseDto();

        dto.setPetId(source.getId());
        dto.setPetName(source.getName());
        dto.setAlive(source.getIsAlive());
        dto.setHappiness(source.getHappiness());
        dto.setHunger(source.getHunger());

        return dto;
    }
}
