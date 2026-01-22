package org.example.tamagotchi.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.tamagotchi.entity.Pet;
import org.example.tamagotchi.exception.PetAlreadyDiedException;
import org.example.tamagotchi.exception.PetNotFoundException;
import org.example.tamagotchi.repository.PetRepository;
import org.example.tamagotchi.service.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    @Transactional
    public Pet adoptPet(String name) {
        Pet pet = new Pet();

        pet.setName(name);
        pet.setHappiness(100);
        pet.setHunger(0);
        pet.setIsAlive(true);
        pet.setCreatedAt(Instant.now());
        pet.setLastUpdated(Instant.now());

        return petRepository.save(pet);
    }

    @Override
    @Transactional
    public Pet feedPet(Long petId) {
        Pet pet = this.getPetOrThrow(petId);
        this.checkIsAlive(pet);

        int newHunger = Math.max(0, pet.getHunger() - 20);
        pet.setHunger(newHunger);

        pet.setLastUpdated(Instant.now());
        return petRepository.save(pet);
    }

    @Override
    @Transactional
    public Pet playWithPet(Long petId) {
        Pet pet = this.getPetOrThrow(petId);
        this.checkIsAlive(pet);

        int newHappiness = Math.min(100, pet.getHappiness() + 20);
        int newHunger = Math.min(100, pet.getHunger() + 10);

        pet.setHappiness(newHappiness);
        pet.setHunger(newHunger);

        pet.setLastUpdated(Instant.now());
        return petRepository.save(pet);
    }

    @Override
    @Transactional
    public Pet getPetStatus(Long petId) {
        return this.getPetOrThrow(petId);
    }

    private Pet getPetOrThrow(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("Питомец с id " + id + " не найден"));
    }

    private void checkIsAlive(Pet pet) {
        if (!pet.getIsAlive()) {
            throw new PetAlreadyDiedException("Питомец " + pet.getName() + " умер. Вы не можете с ним взаимодействовать.");
        }
    }

}
