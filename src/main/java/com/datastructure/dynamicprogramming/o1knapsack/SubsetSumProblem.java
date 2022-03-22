package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.stream.IntStream;

public class SubsetSumProblem {

  public static void main(String[] args) {
    int[] arr = {1, 5, 11, 5};
    int sum = 11;
    int n = arr.length;
    System.out.println(
        "Sum : " + sum + " is" + (isSubsetPresent(arr, sum, n) ? " " : " not ") + "present");
  }

  private static boolean isSubsetPresent(int[] arr, int sum, int n) {
    boolean[][] t = new boolean[n + 1][sum + 1];
    IntStream.range(0, sum + 1).forEach(i -> t[0][i] = false);
    IntStream.range(0, n + 1).forEach(i -> t[i][0] = true);
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = (t[i - 1][j - arr[i - 1]]) ||
              (t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }
}