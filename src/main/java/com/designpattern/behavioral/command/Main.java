package com.designpattern.behavioral.command;

public class Main {

  public static void main(String[] args) {
    Stock stock = new Stock("Infy", 100);
    BuyStock buyStock = new BuyStock(stock);
    SellStock sellStock = new SellStock(stock);
    Broker broker = new Broker();
    broker.takeOrder(buyStock);
    broker.takeOrder(sellStock);
    broker.placeOrders();
  }
}
