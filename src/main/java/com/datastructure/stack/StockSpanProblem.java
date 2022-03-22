package com.datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

  public static void main(String[] args) {
    int price[] = {100, 100, 60, 70, 60, 75, 85};
    int n = price.length;
    int S[] = new int[n];

    calculateSpan(price, n, S);
    Arrays.stream(S).forEachOrdered(StockSpanProblem::accept);
    System.out.println();

  }

  private static void calculateSpan(int[] price, int n, int[] s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    s[0] = 1;
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
        stack.pop();
      }
      s[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
      stack.push(i);
    }
  }

  private static void accept(int s) {
    System.out.printf("%d ", s);
  }
}
