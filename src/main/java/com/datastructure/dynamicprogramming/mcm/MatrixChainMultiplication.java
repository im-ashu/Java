package com.datastructure.dynamicprogramming.mcm;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixChainMultiplication {

  public static void main(String[] args) {
    int[] arr = {40, 20, 30, 10, 30};
    int n = arr.length;
    int i = 1;
    int j = n - 1;
    int[][] t = new int[n][n];
    IntStream.range(0, n).forEach(row -> Arrays.fill(t[row], -1));
    System.out.println(mcm(arr, i, j, t));
  }

  private static int mcm(int[] arr, int i, int j, int[][] t) {
    if (i >= j) {
      return 0;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    t[i][j] = Integer.MAX_VALUE;
    for (int k = i; k <= j - 1; k++) {
      int temp = mcm(arr, i, k, t) + mcm(arr, k + 1, j, t) + (arr[i - 1] * arr[k] * arr[j]);
      t[i][j] = Math.min(t[i][j], temp);
    }
    return t[i][j];
  }
}