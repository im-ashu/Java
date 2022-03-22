package com.datastructure.stack;

import java.util.Stack;

public class O1MinimumElement extends Stack<Integer> {

  Stack<Integer> min;

  public O1MinimumElement() {
    super();
    this.min = new Stack<>();
  }

  public static void main(String[] args) {
    O1MinimumElement stack = new O1MinimumElement();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    System.out.println(stack.getMin());
    System.out.println(stack.getMin());
    stack.push(5);
    System.out.println(stack.getMin());
  }

  @Override
  public Integer push(Integer item) {
    if (isEmpty()) {
      min.push(item);
      return super.push(item);
    }
    Integer topOfMinStack = min.peek();
    if (item <= topOfMinStack) {
      min.push(item);
    }
    return super.push(item);
  }

  @Override
  public Integer pop() {
    int x = super.pop();
    int y = min.pop();
    if (y != x) {
      min.push(y);
    }
    return x;
  }

  public int getMin() {
    if (!isEmpty()) {
      return min.peek();
    }
    return Integer.MIN_VALUE;
  }
}
