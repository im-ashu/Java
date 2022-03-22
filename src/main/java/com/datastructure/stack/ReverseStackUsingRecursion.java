package com.datastructure.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {

  static Stack<Character> st = new Stack<>();

  public static void main(String[] args) {

    st.push('1');
    st.push('2');
    st.push('3');
    st.push('4');

    System.out.println("Original Stack");

    System.out.println(st);

    // function to reverse
    // the stack
    reverse();

    System.out.println("Reversed Stack");

    System.out.println(st);
  }

  private static void reverse() {
    if (!st.isEmpty()) {
      char x = st.pop();
      reverse();
      insertAtBottom(x);
    }
  }

  private static void insertAtBottom(char x) {
    if (st.isEmpty()) {
      st.push(x);
    } else {
      char a = st.pop();
      insertAtBottom(x);
      st.push(a);
    }
  }
}
