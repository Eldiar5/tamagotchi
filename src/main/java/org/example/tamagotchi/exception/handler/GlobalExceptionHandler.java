package org.example.tamagotchi.exception.handler;

import org.example.tamagotchi.exception.dto.ErrorResponseDto;
import org.example.tamagotchi.exception.PetAlreadyDiedException;
import org.example.tamagotchi.exception.PetIllegalArgumentException;
import org.example.tamagotchi.exception.PetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(PetNotFoundException ex) {
        ErrorResponseDto errorDto = new ErrorResponseDto(ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PetIllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgument(PetIllegalArgumentException ex) {
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PetAlreadyDiedException.class)
    public ResponseEntity<ErrorResponseDto> handleDeadPet(PetAlreadyDiedException ex) {
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
