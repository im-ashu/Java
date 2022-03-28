package com.leetcode;

import java.util.Stack;

public class MinStack {

  private Long min;
  private Stack<Long> s;

  public MinStack() {
    s = new Stack<>();
    min = Long.MAX_VALUE;
  }

  public static void main(String[] args) {
    final MinStack stack = new MinStack();
    stack.push(Integer.MAX_VALUE - 1);
    stack.push(Integer.MAX_VALUE - 1);
    stack.push(Integer.MAX_VALUE);
    System.out.println(stack.top());
    stack.pop();
    System.out.println(stack.getMin());
    stack.pop();
    System.out.println(stack.getMin());
    stack.pop();
    stack.push(2147483647);
    System.out.println(stack.top());
    System.out.println(stack.getMin());
    stack.push(-2147483648);
    System.out.println(stack.top());
    System.out.println(stack.getMin());
    stack.pop();
    System.out.println(stack.getMin());
  }

  public void push(int val) {
    Long value = (long) val;
    if (s.isEmpty()) {
      min = value;
      s.add(value);
    } else {
      if (value < min) {
        s.add((2 * value) - min);
        min = value;
      } else {
        s.add(value);
      }
    }
  }

  public void pop() {
    Long value = s.pop();
    if (value < min) {
      min = (2L * min) - value;
    }
  }

  public int top() {
    Long value = s.peek();
    if (value < min) {
      return min.intValue();
    } else {
      return value.intValue();
    }
  }

  public int getMin() {
    return min.intValue();
  }
}