package com.example.PPAtask.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PPAtask.Entities.OperationEntity;

@Service
public class AdditionService {

  List<OperationEntity> operations = new ArrayList<>();

  public OperationEntity getSum(Integer a, Integer b) {

    OperationEntity operation = new OperationEntity(a, b);

    operations.add(operation);

    return operation;

  }

  public List<OperationEntity> getAdditionOperations(Integer number, String order) {

    return null;
  }
}
