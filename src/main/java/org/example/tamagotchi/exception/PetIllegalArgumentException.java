package org.example.tamagotchi.exception;

public class PetIllegalArgumentException extends RuntimeException {
    public PetIllegalArgumentException(String message) {
        super(message);
    }

    public PetIllegalArgumentException() {}
}
