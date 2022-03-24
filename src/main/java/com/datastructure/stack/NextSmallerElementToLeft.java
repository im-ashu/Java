package com.datastructure.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElementToLeft {

  public static void main(String[] args) {
    int[] arr = {9, 9, 1, 2, 4, 5, 2, 3, 10};
    int n = arr.length;
    nextSmallerElementToLeft(arr, n);
  }

  private static void nextSmallerElementToLeft(int[] arr, int n) {
    ArrayList<Integer> result = new ArrayList<>(n);
    Stack<Integer> s = new Stack<>();
    for (int element : arr) {
      while (!s.isEmpty() && s.peek() >= element) {
        s.pop();
      }
      result.add(s.isEmpty() ? -1 : s.peek());
      s.add(element);
    }
    result.forEach(e -> System.out.print(e + " "));
  }
}