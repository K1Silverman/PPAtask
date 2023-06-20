package com.example.PPAtask.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PPAtask.Entities.OperationEntity;
import com.example.PPAtask.Exceptions.AddableOutOfRangeException;
import com.example.PPAtask.Services.AdditionService;

import java.util.List;

import jakarta.annotation.Resource;

@RestController
public class AdditionController {

  @Resource
  private AdditionService additionService;

  @GetMapping("/addition-operation")
  public OperationEntity getSum(@RequestParam Integer addableA, @RequestParam Integer addableB) {
    if ((addableA >= 0 && addableA <= 100) && (addableB >= 0 && addableB <= 100)) {
      return additionService.getSum(addableA, addableB);
    } else {
      throw new AddableOutOfRangeException("Request parameter out of range (0 - 100)");
    }
  }

  @GetMapping("/addition-query")
  public List<OperationEntity> getAdditionOperations(@RequestParam Integer queryNumber,
      @RequestParam(required = true) String order) {
    return additionService.getAdditionOperations(queryNumber, order);
  }
}
