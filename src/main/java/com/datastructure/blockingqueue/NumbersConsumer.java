package com.datastructure.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable {

  private final int poisonPill;
  private BlockingQueue<Integer> queue;

  public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
    this.queue = queue;
    this.poisonPill = poisonPill;
  }

  @Override
  public void run() {
    try {
      while (true) {
        final Integer n = queue.take();
        if (n.equals(poisonPill)) {
          return;
        }
        System.out.println(Thread.currentThread().getName() + " result : " + n);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}