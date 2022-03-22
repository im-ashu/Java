package com.datastructure.dynamicprogramming.unboundedknapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RodCutting {

  public static void main(String[] args) {
    int[] price = {5, 6, 8, 8};
    int n = 4;
    System.out.println(maxProfit(price, n));
  }

  private static int maxProfit(int[] price, int n) {
    int[][] t = new int[n + 1][n + 1];
    IntStream.range(0, n + 1).forEach(row -> Arrays.fill(t[row], -1));
    IntStream.range(0, n + 1).forEach(row -> t[row][0] = 0);
    IntStream.range(0, n + 1).forEach(col -> t[0][col] = 0);
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (i <= j) {
          t[i][j] = Math.max(price[i - 1] + t[i][j - i], t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][n];
  }
}