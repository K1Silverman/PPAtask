package com.example.PPAtask.Exceptions;

import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class AdditionException {
  private final String message;
  private final Map<String, String> requestParameters;
  private final HttpStatus httpStatus;
  private final ZonedDateTime timestamp;

  public AdditionException(String message, Map<String, String> requestParameters, HttpStatus httpStatus,
      ZonedDateTime timestamp) {
    this.message = message;
    this.requestParameters = requestParameters;
    this.httpStatus = httpStatus;
    this.timestamp = timestamp;
  }

  public Map<String, String> getRequestParameters() {
    return this.requestParameters;
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
