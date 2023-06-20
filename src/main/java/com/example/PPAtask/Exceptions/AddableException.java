package com.example.PPAtask.Exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class AddableException {
  private final String message;
  private final HttpStatus httpStatus;
  private final ZonedDateTime timestamp;

  public AddableException(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
    this.message = message;
    this.httpStatus = httpStatus;
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return this.message;
  }

  public HttpStatus getHttpStatus() {
    return this.httpStatus;
  }

  public ZonedDateTime getTimestamp() {
    return this.timestamp;
  }

}
