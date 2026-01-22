package org.example.tamagotchi.sheduler;

import lombok.RequiredArgsConstructor;
import org.example.tamagotchi.entity.Pet;
import org.example.tamagotchi.repository.PetRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetLifeCycleScheduler {

    private final PetRepository petRepository;

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void petLifeCycle() {

        List<Pet> pets = petRepository.findAll();

        for (Pet pet : pets) {

            pet.setHunger(pet.getHunger() + 4);
            pet.setHappiness(pet.getHappiness() - 5);

            if (pet.getHappiness() <= 0 || pet.getHunger() >= 100) {
                pet.setIsAlive(false);

                System.out.println("RIP: " + pet.getName() + " умер :(");
            }
        }

        petRepository.saveAll(pets);

    }

}
