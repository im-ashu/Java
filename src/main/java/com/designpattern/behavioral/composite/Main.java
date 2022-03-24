package com.designpattern.behavioral.composite;

public class Main {

  public static void main(String[] args) {
    Department sale = new SalesDepartment("1", "Abc");
    Department finance = new FinanceDepartment("2", "Def");

    HeadDepartment headDepartment = new HeadDepartment("3", "QWERTY");
    headDepartment.addDepartments(sale);
    headDepartment.addDepartments(finance);
    System.out.println(headDepartment);
  }
}
