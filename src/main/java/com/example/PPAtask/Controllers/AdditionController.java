package com.example.PPAtask.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PPAtask.Entities.OperationEntity;
import com.example.PPAtask.Exceptions.AdditionRequestException;
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
      throw new AdditionRequestException("Both parameters must be between 0 and 100 (included)");
    }
  }

  @GetMapping("/addition-query")
  public List<OperationEntity> getAdditionOperations(@RequestParam(required = false) Integer queryNumber,
      @RequestParam(required = true) String order) {

    if (queryNumber == null && !order.equals("")) {
      return additionService.getAllAdditionOperations(order);

    } else if (queryNumber != null && !order.equals("")) {
      return additionService.getAdditionOperations(queryNumber, order);

    } else if (order.equals("")) {
      throw new AdditionRequestException("Order is a required field (asc / desc)");

    } else if (queryNumber < 0 && queryNumber > 100) {
      throw new AdditionRequestException("queryNumber must be between 0 and 100 (included)");

    } else {
      throw new AdditionRequestException("Something went wrong!");
    }
  }
}
