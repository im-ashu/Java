package com.designpattern.structural.composite;

public class Main {

  public static void main(String[] args) {
    Employee CEO = new Employee("John", "CEO", 57);

    Employee headSales = new Employee("Robert", "Head Sales", 45);
    Employee headMarketing = new Employee("Michael", "Head Marketing", 45);

    Employee clerk1 = new Employee("Laura", "Marketing", 22);
    Employee clerk2 = new Employee("Bob", "Marketing", 23);

    Employee salesExecutive1 = new Employee("Richard", "Sales", 23);
    Employee salesExecutive2 = new Employee("Rob", "Sales", 22);

    CEO.getSubordinates().add(headSales);
    CEO.getSubordinates().add(headMarketing);

    headSales.getSubordinates().add(salesExecutive1);
    headSales.getSubordinates().add(salesExecutive2);

    headMarketing.getSubordinates().add(clerk1);
    headMarketing.getSubordinates().add(clerk2);

    System.out.println(CEO);
    CEO.getSubordinates().forEach(employee -> {
      System.out.println(employee);
      employee.getSubordinates().forEach(System.out::println);
    });

  }
}
