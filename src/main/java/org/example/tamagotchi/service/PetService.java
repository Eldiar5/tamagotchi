package org.example.tamagotchi.service;

import org.example.tamagotchi.entity.Pet;

public interface PetService {

    Pet adoptPet(String name);

    Pet feedPet(Long petId);

    Pet playWithPet(Long petId);

    Pet getPetStatus(Long petId);
}
