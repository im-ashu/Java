package com.datastructure.dynamicprogramming.unboundedknapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UnboundedKnapsack {

  public static void main(String[] args) {
    int[] weights = {1, 3, 4, 5};
    int[] values = {3, 3, 4, 5};
    int n = weights.length;
    int w = 7;
    unboundedKnapsack(weights, values, n, w);
  }

  private static int unboundedKnapsack(int[] weights, int[] values, int n, int w) {
    int rowBound = n + 1;
    int colBound = w + 1;
    int[][] t = new int[rowBound][colBound];
    IntStream.range(0, rowBound).forEach(row -> Arrays.fill(t[row], -1));
    IntStream.range(0, rowBound).forEach(row -> t[row][0] = 0);
    IntStream.range(0, colBound).forEach(col -> t[0][col] = 0);

    for (int i = 1; i < rowBound; i++) {
      for (int j = 1; j < colBound; j++) {
        if (weights[i - 1] <= j) {
          t[i][j] = Math.max(values[i - 1] + t[i][j - weights[i - 1]], t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][w];
  }
}