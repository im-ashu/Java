package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class O1KnapsackTabulatedSolution {

  public static void main(String[] args) {
    int[] weights = {1, 3, 4, 5};
    int[] values = {3, 3, 4, 5};
    int n = weights.length;
    int knapsackWeight = 7;
    o1knapsack(weights, values, n, knapsackWeight);
  }

  private static int o1knapsack(int[] weights, int[] values, int n, int w) {
    int[][] t = new int[n + 1][w + 1];
    IntStream.range(1, n).forEach(i -> Arrays.fill(t[i], -1));
    IntStream.range(0, n + 1).forEach(i -> t[i][0] = 0);
    IntStream.range(0, w + 1).forEach(i -> t[0][i] = 0);
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < w + 1; j++) {
        if (weights[i - 1] <= j) {
          t[i][j] = Math.max(
              values[i - 1] + t[i - 1][j - weights[i - 1]],
              t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][w];
  }
}