package com.to.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.to.exception.BandNotFoundException;
import com.to.exception.MusicianNotFoundException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({BandNotFoundException.class, MusicianNotFoundException.class})
    public ResponseEntity<String> handleBandNotFoundException(BandNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
