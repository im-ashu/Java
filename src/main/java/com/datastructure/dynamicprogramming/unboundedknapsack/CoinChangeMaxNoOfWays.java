package com.datastructure.dynamicprogramming.unboundedknapsack;

import java.util.stream.IntStream;

public class CoinChangeMaxNoOfWays {

  public static void main(String[] args) {
    int[] coin = {1, 2, 3};
    int sum = 5;
    int n = coin.length;
    System.out.println(maxWays(coin, n, sum));
  }

  private static int maxWays(int[] coin, int n, int sum) {
    int rowBound = n + 1;
    int colBound = sum + 1;
    int[][] t = new int[rowBound][colBound];
// IntStream.range(0, rowBound).forEach(row -> Arrays.fill(t[row], -1));
    IntStream.range(0, colBound).forEach(col -> t[0][col] = 0);
    IntStream.range(0, rowBound).forEach(row -> t[row][0] = 1);
    for (int i = 1; i < rowBound; i++) {
      for (int j = 1; j < colBound; j++) {
        if (coin[i - 1] <= j) {
          t[i][j] = t[i][j - coin[i - 1]] + t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }
}