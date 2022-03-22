package com.designpattern.behavioral.command;

public class SellStock extends Order {

  private final Stock stock;

  SellStock(Stock s) {
    stock = s;
  }

  @Override
  void execute() {
    stock.sell();
  }
}

