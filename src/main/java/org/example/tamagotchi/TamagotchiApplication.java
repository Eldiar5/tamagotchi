package org.example.tamagotchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TamagotchiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TamagotchiApplication.class, args);
    }

}
