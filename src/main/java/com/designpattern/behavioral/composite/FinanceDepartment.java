package com.designpattern.behavioral.composite;

public class FinanceDepartment implements Department {

  private final String id;
  private final String name;

  public FinanceDepartment(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public void printNameOfDepartment() {
    System.out.println(getClass().getSimpleName());
  }

  @Override
  public String toString() {
    return "FinanceDepartment{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
