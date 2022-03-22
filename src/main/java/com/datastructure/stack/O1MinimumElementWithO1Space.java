package com.datastructure.stack;

import java.util.Stack;

public class O1MinimumElementWithO1Space extends Stack<Integer> {

  int minimumElement;

  public static void main(String[] args) {
    O1MinimumElementWithO1Space stack = new O1MinimumElementWithO1Space();
    stack.push(20);
    stack.push(10);
    stack.push(30);
    System.out.println(stack.getMinimumElement());
    stack.push(50);
    System.out.println(stack.getMinimumElement());
  }

  @Override
  public Integer push(Integer item) {
    if (isEmpty()) {
      minimumElement = item;
      return super.push(item);
    }
    if (item < minimumElement) {
      int temp = (2 * item) - minimumElement;
      minimumElement = item;
      return super.push(temp);
    }
    return super.push(item);
  }

  @Override
  public Integer pop() {
    Integer item = super.pop();
    if (item < minimumElement) {
      int result = minimumElement;
      minimumElement = (2 * minimumElement) - item;
      return result;
    } else {
      return item;
    }
  }

  public int getMinimumElement() {
    if (isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return minimumElement;
  }
}
