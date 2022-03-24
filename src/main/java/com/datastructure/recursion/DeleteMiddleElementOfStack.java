package com.datastructure.recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(2);
    s.push(5);
    s.push(0);
    s.push(-1);
    s.push(1);
    int k = (s.size() >> 1) + 1;
    deleteMid(s, k);
    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  private static void deleteMid(Stack<Integer> s, int k) {
    if (k == 1) {
      s.pop();
      return;
    }
    final Integer pop = s.pop();
    deleteMid(s, k - 1);
    s.push(pop);
  }
}