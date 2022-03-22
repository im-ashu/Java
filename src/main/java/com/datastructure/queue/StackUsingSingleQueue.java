package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {

  private final Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) {
    StackUsingSingleQueue stack = new StackUsingSingleQueue();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  public void push(int item) {
    int size = queue.size();
    queue.add(item);
    for (int i = 0; i < size; i++) {
      Integer otherElements = queue.remove();
      queue.add(otherElements);
    }
  }

  public int pop() {
    if (queue.isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return queue.remove();
  }
}
