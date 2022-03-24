package com.datastructure.recursion;

import java.util.Stack;

public class SortStack {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(2);
    s.push(5);
    s.push(0);
    s.push(-1);
    s.push(1);
    sort(s);
    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  private static void sort(Stack<Integer> s) {
    if (s.size() == 1) {
      return;
    }
    final Integer lastEle = s.pop();
    sort(s);
    insert(s, lastEle);
  }

  private static void insert(Stack<Integer> s, Integer lastEle) {
    if (s.isEmpty() || s.peek() <= lastEle) {
      s.push(lastEle);
      return;
    }
    final Integer val = s.pop();
    insert(s, lastEle);
    s.push(val);
  }
}