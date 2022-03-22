package com.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

public class QueuesATaleOfTwoStacks {

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }

  static class MyQueue<Integer> {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(Integer nextInt) {
      stack1.push(nextInt);
    }

    public void dequeue() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      stack2.pop();
    }

    public Integer peek() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      return stack2.peek();
    }
  }
}

