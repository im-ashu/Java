package com.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(4);
    Thread thread1 = new Thread(new Employee("Emp 1", 1000, countDownLatch));
    Thread thread2 = new Thread(new Employee("Emp 2", 1000, countDownLatch));
    Thread thread3 = new Thread(new Employee("Emp 3", 1000, countDownLatch));
    Thread thread4 = new Thread(new Employee("Emp 4", 1000, countDownLatch));

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    countDownLatch.await();
    System.out.println("Driver started the cab");
  }
}

class Employee implements Runnable {

  private final String name;
  private final int timeToReachParking;
  private final CountDownLatch countDownLatch;

  public Employee(String name, int timeToReachParking,
      CountDownLatch countDownLatch) {
    this.name = name;
    this.timeToReachParking = timeToReachParking;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(timeToReachParking);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + " has taken the seat");
    countDownLatch.countDown();
  }
}
