package com.datastructure.stack;

import java.util.Stack;

public class DeleteMiddleElement {

  public static void main(String[] args) {
    Stack<Character> st = new Stack<Character>();

    // push elements into the stack
    st.push('1');
    st.push('2');
    st.push('3');
    st.push('4');
    st.push('5');
    st.push('6');
    st.push('7');

    System.out.println("Before Deletion");
    System.out.println(st);
    deleteMid(st, st.size(), 0);
    System.out.println("After Deletion");
    System.out.println(st);
  }

  private static void deleteMid(Stack<Character> st, int size, int current) {
    if (st.isEmpty() && current == size) {
      return;
    }
    Character item = st.pop();
    deleteMid(st, size, current + 1);
    if (current != size / 2) {
      st.push(item);
    }
  }
}
