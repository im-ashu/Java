package com.designpattern.behavioral.composite;

public class SalesDepartment implements Department {

  private final String id;
  private final String name;

  public SalesDepartment(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public void printNameOfDepartment() {
    System.out.println(getClass().getSimpleName());
  }

  @Override
  public String toString() {
    return "SalesDepartment{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
