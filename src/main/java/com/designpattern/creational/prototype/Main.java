package com.designpattern.creational.prototype;

public class Main {

  public static void main(String[] args) throws CloneNotSupportedException {
    Vehicle vehicle = new Vehicle();
    vehicle.insertVehicles();
    Vehicle vehicle1 = vehicle.clone();
    vehicle1.getVehicleList().add("A4");
    vehicle.getVehicleList().remove("Civic");
    System.out.println(vehicle);
    System.out.println(vehicle1);
  }
}
