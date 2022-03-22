package com.designpattern.behavioral.composite;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {

  private final String id;
  private final String name;
  private final List<Department> departments;

  public HeadDepartment(String id, String name) {
    this.id = id;
    this.name = name;
    this.departments = new ArrayList<>();
  }

  public void addDepartments(Department department) {
    departments.add(department);
  }

  @Override
  public void printNameOfDepartment() {
    System.out.println(getClass().getSimpleName());
  }

  @Override
  public String toString() {
    return "HeadDepartment{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", departments=" + departments +
        '}';
  }
}
