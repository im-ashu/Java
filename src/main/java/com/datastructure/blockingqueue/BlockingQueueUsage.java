package com.datastructure.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueUsage {

  public static void main(String[] args) {
    int bound = 10;
    int nProducers = 4;
    int nConsumers = 2;
    int poisonPill = Integer.MAX_VALUE;
    int poisonPillProducers = nConsumers / nProducers;
    int mod = nConsumers % nProducers;
    BlockingQueue<Integer> q = new LinkedBlockingQueue<>(bound);
    for (int i = 1; i < nProducers; i++) {
      new Thread(new NumbersProducer(q, poisonPill, poisonPillProducers)).start();
    }
    for (int i = 0; i < nConsumers; i++) {
      new Thread(new NumbersConsumer(q, poisonPill)).start();
    }
    new Thread(new NumbersProducer(q, poisonPill, poisonPillProducers + mod)).start();
  }
}