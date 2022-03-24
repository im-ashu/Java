package com.datastructure.stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

public class StockSpanProblem {

  public static void main(String[] args) {
    int[] arr = {100, 80, 60, 75, 110, 75, 85};
    int n = arr.length;
    stockSpan(arr, n);
  }

  private static void stockSpan(int[] arr, int n) {
    ArrayList<Integer> result = new ArrayList<>(n);
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        s.pop();
      }
      result.add(s.isEmpty() ? -1 : s.peek());
      s.add(i);
    }
    IntStream.range(0, n).mapToObj(i -> i - result.get(i) + " ").forEach(System.out::print);
  }
}