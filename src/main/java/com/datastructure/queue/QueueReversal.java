package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    q.add(4);
    q.add(3);
    q.add(1);
    q.add(10);
    q.add(2);
    q.add(6);
    Queue<Integer> rev = rev(q);
    for (Integer integer : rev) {
      System.out.print(integer + " ");
    }

  }

  public static Queue<Integer> rev(Queue<Integer> q) {
    //add code here.
    Stack<Integer> stack = new Stack<>();
    while (!q.isEmpty()) {
      stack.push(q.poll());
    }
    while (!stack.isEmpty()) {
      q.add(stack.pop());
    }
    return q;

  }
}