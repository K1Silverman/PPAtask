package com.example.PPAtask.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AdditionExceptionHandler {

  @ExceptionHandler(value = { AdditionRequestException.class })
  public ResponseEntity<Object> handleAdditionException(AdditionRequestException e, HttpServletRequest request) {

    Map<String, String[]> parameterMap = request.getParameterMap();
    Map<String, String> requestParameters = new HashMap<>();
    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
      String key = entry.getKey();
      String[] values = entry.getValue();
      if (values.length > 0) {
        requestParameters.put(key, values[0]);
      }
    }
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    AdditionException additionException = new AdditionException(
        e.getMessage(),
        requestParameters,
        badRequest,
        ZonedDateTime.now(ZoneId.systemDefault()));
    return new ResponseEntity<>(additionException, badRequest);
  }

}
