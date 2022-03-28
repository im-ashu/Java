package com.datastructure.stack;

import java.util.Objects;
import java.util.Stack;

public class MinStack extends Stack<Integer> {

  Stack<Integer> supportingStack = new Stack<>();

  public static void main(String[] args) {
    MinStack s = new MinStack();
    s.push(Integer.MAX_VALUE - 1);
    s.push(Integer.MAX_VALUE - 1);
    s.push(Integer.MAX_VALUE);
    s.peek();
    s.pop();
    s.pop();
    s.pop();
    System.out.println(s.getMin());
  }

  @Override
  public Integer push(Integer item) {
    Integer data = super.push(item);
    if (supportingStack.isEmpty() || (supportingStack.peek() >= data)) {
      supportingStack.push(data);
    }
    return data;
  }

  @Override
  public synchronized Integer pop() {
    Integer popElement = super.pop();
    if (Objects.equals(supportingStack.peek(), popElement)) {
      supportingStack.pop();
    }
    return popElement;
  }

  public int getMin() {
    if (supportingStack.isEmpty()) {
      return -1;
    }
    return supportingStack.peek();
  }
}
