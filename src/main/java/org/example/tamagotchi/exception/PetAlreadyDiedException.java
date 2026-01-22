package org.example.tamagotchi.exception;

public class PetAlreadyDiedException extends RuntimeException {

    public PetAlreadyDiedException(String message) {
        super(message);
    }

    public PetAlreadyDiedException() {}
}
