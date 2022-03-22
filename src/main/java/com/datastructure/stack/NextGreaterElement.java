package com.datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

  public static void main(String args[]) {
    int arr[] = {15, 10, 7, 6, 11, 16};
    int n = arr.length;
    int ans[] = new int[n];
    printNGE(arr, n, ans);
    Arrays.stream(ans).forEachOrdered(NextGreaterElement::accept);
  }

  private static void printNGE(int[] arr, int n, int[] ans) {
    Stack<Integer> stack = new Stack<>();
    stack.push(arr[0]);
    int next;
    int j = 0;
    int element;
    for (int i = 1; i < n; i++) {
      next = arr[i];
      if (!stack.isEmpty()) {
        element = stack.pop();
        while (element < next) {
          ans[j] = next;
          j++;
          if (stack.isEmpty()) {
            break;
          }
          element = stack.pop();
        }
        if (element > next) {
          stack.push(element);
        }
      }
      stack.push(next);
    }
    while (!stack.isEmpty()) {
      stack.pop();
      ans[j] = -1;
      j++;
    }
  }

  private static void accept(int s) {
    System.out.printf("%d ", s);
  }
}
