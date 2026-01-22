package org.example.tamagotchi.exception;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(String message) {
        super(message);
    }

    public PetNotFoundException() {}
}
