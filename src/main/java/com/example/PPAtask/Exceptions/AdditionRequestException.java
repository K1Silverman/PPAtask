package com.example.PPAtask.Exceptions;

public class AdditionRequestException extends RuntimeException {

  public AdditionRequestException(String message) {
    super(message);
  }

  public AdditionRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}
