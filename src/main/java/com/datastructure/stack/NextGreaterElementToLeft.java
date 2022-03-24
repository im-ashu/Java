package com.datastructure.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementToLeft {

  public static void main(String[] args) {
    int[] arr = {9, 9, 7, 5, 6, 4, 3, 2, 1};
    int n = arr.length;
    nextGreaterElementToLeft(arr, n);
  }

  private static void nextGreaterElementToLeft(int[] arr, int n) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    for (int i : arr) {
      while (!s.isEmpty() && s.peek() <= i) {
        s.pop();
      }
      result.add(s.isEmpty() ? -1 : s.peek());
      s.add(i);
    }
    result.forEach(e -> System.out.print(e + " "));
  }
}