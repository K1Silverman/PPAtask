package com.example.PPAtask.Entities;

public class OperationEntity {
  private Integer a;
  private Integer b;
  private Integer sum;

  public OperationEntity(Integer a, Integer b) {
    this.a = a;
    this.b = b;
    this.sum = a + b;
  }

  public Integer getA() {
    return this.a;
  }

  public void setA(Integer a) {
    this.a = a;
  }

  public Integer getB() {
    return this.b;
  }

  public void setB(Integer b) {
    this.b = b;
  }

  public Integer getSum() {
    return this.sum;
  }

  public void setSum(Integer sum) {
    this.sum = sum;
  }
  
  public OperationEntity() {
  }
}

