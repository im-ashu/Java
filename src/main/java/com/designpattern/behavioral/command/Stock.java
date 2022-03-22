package com.designpattern.behavioral.command;

public class Stock {

  private final String name;
  private final int quantity;

  public Stock(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }


  public void buy() {
    System.out.println(this + " bought");
  }

  @Override
  public String toString() {
    return "Stock{" +
        "name='" + name + '\'' +
        ", quantity=" + quantity +
        '}';
  }

  public void sell() {
    System.out.println(this + " sold");
  }

}
