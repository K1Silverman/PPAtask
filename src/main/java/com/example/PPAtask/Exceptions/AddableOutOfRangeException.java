package com.example.PPAtask.Exceptions;

public class AddableOutOfRangeException extends RuntimeException {
  
  public AddableOutOfRangeException(String message) {
    super(message);
  }

  public AddableOutOfRangeException(String message, Throwable cause) {
    super(message, cause);
  }
}
