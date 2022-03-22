package com.designpattern.behavioral.command;

public class BuyStock extends Order {

  private final Stock stock;

  public BuyStock(Stock stock) {
    this.stock = stock;
  }

  @Override
  public void execute() {
    stock.buy();
  }
}
