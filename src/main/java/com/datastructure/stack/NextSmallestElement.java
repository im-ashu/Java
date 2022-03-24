package com.datastructure.stack;

import java.util.Stack;

public class NextSmallestElement {

  public static void main(String[] args) {
    int[] arr = {21, 11, 13, 3};
    int n = arr.length;
    nextSmallestElement(arr, n);
  }

  private static void nextSmallestElement(int[] arr, int n) {
    Stack<Integer> s = new Stack<>();
    int[] nse = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      while (!s.isEmpty() && arr[i] <= s.peek()) {
        s.pop();
      }
      nse[i] = s.isEmpty() ? -1 : s.peek();
      s.push(arr[i]);
    }
   for (int i = 0; i < n; i++) {
    System.out.println(arr[i] + " --> " + nse[i]);
   }
  }
}