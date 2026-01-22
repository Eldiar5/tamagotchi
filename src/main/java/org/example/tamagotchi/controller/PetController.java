package org.example.tamagotchi.controller;

import lombok.RequiredArgsConstructor;
import org.example.tamagotchi.dto.response.PetResponseDto;
import org.example.tamagotchi.entity.Pet;
import org.example.tamagotchi.exception.PetIllegalArgumentException;
import org.example.tamagotchi.mapper.PetMapper;
import org.example.tamagotchi.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;
    private final PetMapper petMapper;

    @PostMapping
    public PetResponseDto createPet(@RequestParam String name) {

        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new PetIllegalArgumentException("Имя питомца не может быть пустым.");
        }

        Pet pet = this.petService.adoptPet(name);

        return this.petMapper.dtoEnrichment(pet);
    }

    @PostMapping("/{id}/feed")
    public PetResponseDto feedPetById(@PathVariable Long id){
        Pet pet = this.petService.feedPet(id);

        return this.petMapper.dtoEnrichment(pet);
    }

    @PostMapping("/{id}/play")
    public PetResponseDto playWithPetById(@PathVariable Long id){
        Pet pet = this.petService.playWithPet(id);

        return this.petMapper.dtoEnrichment(pet);
    }

    @GetMapping("/{id}")
    public PetResponseDto getPetById(@PathVariable Long id){
        Pet pet = this.petService.getPetStatus(id);

        return this.petMapper.dtoEnrichment(pet);
    }

}
