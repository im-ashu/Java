package com.datastructure.stack;

import java.util.Stack;

public class NextGreaterElement {

  public static void main(String[] args) {

    int[] arr = {11, 13, 21, 3};
    int n = arr.length;
    printNGE(arr, n);
  }

  private static void printNGE(int[] arr, int n) {
    Stack<Integer> stack = new Stack<>();
    int[] nge = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }
      nge[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(arr[i]);
    }
    while (!stack.isEmpty()) {
      stack.pop();
    }
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i] + " --> " + nge[i]);
    }
  }
}