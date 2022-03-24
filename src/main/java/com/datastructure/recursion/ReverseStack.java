package com.datastructure.recursion;

import java.util.Stack;

public class ReverseStack {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(2);
    s.push(5);
    s.push(0);
    s.push(-1);
    s.push(1);
    reverse(s);
    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  private static void reverse(Stack<Integer> s) {
    if (s.size() == 1) {
      return;
    }
    final Integer val = s.pop();
    reverse(s);
    insertInEnd(s, val);
  }

  private static void insertInEnd(Stack<Integer> s, Integer val) {
    if (s.isEmpty()) {
      s.push(val);
      return;
    }
    int value = s.pop();
    insertInEnd(s, val);
    s.push(value);
  }
}