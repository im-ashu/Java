package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.stream.IntStream;

public class CountSubsetSum {

  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 6, 8, 10};
    int sum = 8;
    int n = arr.length;
    System.out.println(countSubsetSum(arr, sum, n));
  }

  private static int countSubsetSum(int[] arr, int sum, int n) {
    int[][] t = new int[n + 1][sum + 1];
    IntStream.range(0, sum + 1).forEach(col -> t[0][col] = 0);
    IntStream.range(0, n + 1).forEach(row -> t[row][0] = 1);
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }
}