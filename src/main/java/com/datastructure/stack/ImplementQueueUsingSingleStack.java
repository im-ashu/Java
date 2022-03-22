package com.datastructure.stack;

import java.util.Stack;

public class ImplementQueueUsingSingleStack {

  public static void main(String[] args) {
    QueueWithSingleStacks queue = new QueueWithSingleStacks();
    queue.enQueue(1);
    queue.enQueue(5);
    queue.enQueue(3);
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
  }

  static class QueueWithSingleStacks {

    Stack<Integer> stack;

    public QueueWithSingleStacks() {
      stack = new Stack<>();
    }

    void enQueue(Integer data) {
      stack.push(data);
    }

    public Integer deQueue() {
      int x;
      int data;
      if (stack.isEmpty()) {
        return Integer.MIN_VALUE;
      } else if (stack.size() == 1) {
        return stack.pop();
      } else {
        x = stack.pop();
        data = deQueue();
        stack.push(x);
        return data;
      }
    }
  }
}



