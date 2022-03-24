package com.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Cloneable {

  private final List<String> vehicleList;

  public Vehicle() {
    this.vehicleList = new ArrayList<>();
  }

  public Vehicle(List<String> vehicleList) {
    this.vehicleList = vehicleList;
  }

  public void insertVehicles() {
    vehicleList.add("Amaze");
    vehicleList.add("City");
    vehicleList.add("Civic");
  }

  public List<String> getVehicleList() {
    return vehicleList;
  }

  @Override
  protected Vehicle clone() throws CloneNotSupportedException {
    List<String> vehicles = new ArrayList<>(getVehicleList());
    return new Vehicle(vehicles);
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "vehicleList=" + vehicleList +
        '}';
  }
}
