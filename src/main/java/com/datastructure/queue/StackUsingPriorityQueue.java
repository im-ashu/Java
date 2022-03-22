package com.datastructure.queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import org.javatuples.Pair;

public class StackUsingPriorityQueue {

  private final Queue<Pair<Integer, Integer>> queue;
  private int count;

  public StackUsingPriorityQueue() {
    this.queue = new PriorityQueue<>(
        Collections.reverseOrder(Comparator.comparing(Pair::getValue0)));
    this.count = 0;
  }

  public static void main(String[] args) {
    StackUsingPriorityQueue stack = new StackUsingPriorityQueue();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(4);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  public void push(int item) {
    count++;
    Pair<Integer, Integer> pair = new Pair<>(count, item);
    queue.add(pair);
  }

  public int pop() {
    if (queue.isEmpty()) {
      return Integer.MIN_VALUE;
    }
    count--;
    return queue.remove().getValue1();
  }

}
