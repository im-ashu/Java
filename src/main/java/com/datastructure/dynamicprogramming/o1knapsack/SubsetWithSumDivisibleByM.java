package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SubsetWithSumDivisibleByM {

  public static void main(String[] args) {
    int[] arr = {3, 1, 7, 5};
    int n = arr.length;
    int m = 4;

    if (modularSum(arr, n, m)) {
      System.out.print("YES\n");
    } else {
      System.out.print("NO\n");
    }
  }

  private static boolean modularSum(int[] arr, int n, int m) {
    int sum = Arrays.stream(arr).sum();
    boolean[][] t = subsetSum(arr, n, sum);
    for (int i = 1; i <= sum; i++) {
      if (t[n][i] && i % m == 0) {
        return true;
      }
    }
    return false;
  }

  private static boolean[][] subsetSum(int[] arr, int n, int sum) {
    int rowBound = n + 1;
    int colBound = sum + 1;
    boolean[][] t = new boolean[rowBound][colBound];
    IntStream.range(0, rowBound).forEach(row -> t[row][0] = true);
    for (int i = 1; i < rowBound; i++) {
      for (int j = 1; j < colBound; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t;
  }
}