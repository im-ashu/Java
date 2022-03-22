package com.datastructure.stack;

import java.util.Stack;

public class SortStackUsingRecursion {

  static Stack<Integer> st = new Stack<>();

  public static void main(String... args) {

    st.push(4);
    st.push(3);
    st.push(2);
    st.push(1);

    System.out.println("Original Stack");

    System.out.println(st);

    // function to sort
    // the stack
    sort();
    System.out.println("Sorted Stack");

    System.out.println(st);
  }

  private static void sort() {
    if (!st.isEmpty()) {
      int x = st.pop();
      sort();
      sortedInsert(x);
    }
  }

  private static void sortedInsert(int x) {
    if (st.isEmpty() || st.peek() < x) {
      st.push(x);
    } else {
      int a = st.pop();
      sortedInsert(x);
      st.push(a);
    }
  }
}
