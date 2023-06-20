package com.example.PPAtask.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

  public List<OperationEntity> getAllAdditionOperations(String order) {

    sortOperations(order);

    return operations;
  }

  public List<OperationEntity> getAdditionOperations(Integer number, String order) {

    sortOperations(order);

    List<OperationEntity> queriedOperations = new ArrayList<>();

    for (OperationEntity operation : operations) {
      if (operation.getA() == number || operation.getB() == number || operation.getSum() == number) {
        queriedOperations.add(operation);
      }
    }
    return queriedOperations;
  }

  public void sortOperations(String order) {

    order = order.toLowerCase();
    if (order.equals("asc")) {
      Collections.sort(operations, new Comparator<OperationEntity>() {
        @Override
        public int compare(OperationEntity value1, OperationEntity value2) {
          return Integer.compare(value1.getSum(), value2.getSum());
        }
      });
    } else {
      Collections.sort(operations, new Comparator<OperationEntity>() {
        @Override
        public int compare(OperationEntity value1, OperationEntity value2) {
          return Integer.compare(value2.getSum(), value1.getSum());
        }
      });
    }

  }
}
