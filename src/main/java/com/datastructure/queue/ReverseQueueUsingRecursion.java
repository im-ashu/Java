package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {

  static Queue<Integer> queue = new LinkedList<>();

  private static void reverseQueue() {
    if (queue.isEmpty() || queue.size() == 1) {
      return;
    }
    int element = queue.poll();
    reverseQueue();
    queue.add(element);
  }

  public static void main(String[] args) {
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);
    queue.add(50);
    queue.add(60);
    queue.add(70);
    queue.add(80);
    queue.add(90);
    queue.add(100);
    System.out.println(queue);
    reverseQueue();
    System.out.println(queue);
  }


}
