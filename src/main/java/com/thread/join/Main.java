package com.thread.join;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new Player(), "Player 1");
    Thread t2 = new Thread(new Player(), "Player 2");

    t1.start();
    t2.start();

    t1.join();
    System.out.println("Waiting for Player 2");
    t2.join();
  }

}
