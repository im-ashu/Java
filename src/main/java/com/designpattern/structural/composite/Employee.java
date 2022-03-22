package com.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {

  private final String name;
  private final String dept;
  private final int age;
  private List<Employee> subordinates;

  public Employee(String name, String dept, int age) {
    this.name = name;
    this.dept = dept;
    this.age = age;
    subordinates = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", dept='" + dept + '\'' +
        ", age=" + age +
        ", subordinates=" + subordinates +
        '}';
  }

  public String getName() {
    return name;
  }

  public String getDept() {
    return dept;
  }

  public int getAge() {
    return age;
  }

  public List<Employee> getSubordinates() {
    return subordinates;
  }
}
