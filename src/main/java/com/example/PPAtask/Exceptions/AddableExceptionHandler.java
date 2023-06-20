package com.example.PPAtask.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddableExceptionHandler {

  @ExceptionHandler(value = { AddableOutOfRangeException.class })
  public ResponseEntity<Object> handleAddableOutOfRangeException(AddableOutOfRangeException e) {

    HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    AddableException addableException = new AddableException(
        e.getMessage(),
        badRequest,
        ZonedDateTime.now(ZoneId.systemDefault()));
    return new ResponseEntity<>(addableException, badRequest);
  }
}
