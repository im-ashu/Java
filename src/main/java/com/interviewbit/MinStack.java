package com.interviewbit;

import java.util.Stack;

public class MinStack {

  Stack<Integer> s = new Stack<>();
  int min = Integer.MAX_VALUE;

  public void push(int x) {
    if (s.isEmpty()) {
      s.push(x);
      min = x;
    } else {
      if (x < min) {
        int temp = x;
        x = (2 * x) - min;
        min = temp;
      }
      s.push(x);
    }
  }

  public void pop() {
    if (!s.isEmpty()) {
      if (s.peek() < min) {
        min = 2 * min - s.pop();
      } else {
        s.pop();
      }
    }
  }

  public int top() {
    if (s.isEmpty()) {
      return -1;
    } else {
      if (s.peek() < min) {
        return min;
      } else {
        return s.peek();
      }
    }
  }

  public int getMin() {
    return min;
  }
}