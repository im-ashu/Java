package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class O1Knapsack {

  public static void main(String[] args) {
    int[] weights = {1, 3, 4, 5};
    int[] values = {3, 3, 4, 5};
    int n = weights.length;
    int knapsackWeight = 7;
    int[][] t = new int[n + 1][knapsackWeight + 1];
    IntStream.range(0, n + 1).forEach(i -> Arrays.fill(t[i], -1));
    o1knapsack(weights, values, n, knapsackWeight, t);
  }

  private static int o1knapsack(int[] weights, int[] values, int n, int w, int[][] t) {

    if (n == 0 || w == 0) {
      return 0;
    }
    if (t[n][w] != -1) {
      return t[n][w];
    }
    if (weights[n - 1] <= w) {
      return (t[n][w] = Math.max(values[n - 1] +
              o1knapsack(weights, values, n - 1, w - weights[n - 1], t),
          o1knapsack(weights, values, n - 1, w, t)));
    } else {
      return (t[n][w] = o1knapsack(weights, values, n - 1, w, t));
    }
  }
}