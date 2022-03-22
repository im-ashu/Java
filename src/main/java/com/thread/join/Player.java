package com.thread.join;

public class Player implements Runnable {

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " is finished");
  }
}
