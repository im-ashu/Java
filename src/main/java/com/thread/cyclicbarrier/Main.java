package com.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
        () -> System.out.println("Running Cyclic Barrier Runnable"));

    Thread thread1 = new Thread(new Player(cyclicBarrier), "Player 1");
    Thread thread2 = new Thread(new Player(cyclicBarrier), "Player 2");
    Thread thread3 = new Thread(new Player(cyclicBarrier), "Player 3");

    thread1.start();
    thread2.start();
    thread3.start();
  }
}

class Player implements Runnable {

  private final CyclicBarrier cyclicBarrier;

  public Player(CyclicBarrier cyclicBarrier) {
    this.cyclicBarrier = cyclicBarrier;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
      cyclicBarrier.await();
      System.out.println(Thread.currentThread().getName() + " has passed the barrier");
      cyclicBarrier.await();
      System.out.println(Thread.currentThread().getName() + " is waiting on another barrier");
      cyclicBarrier.await();
      System.out.println(Thread.currentThread().getName() + " has passed another barrier");
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
