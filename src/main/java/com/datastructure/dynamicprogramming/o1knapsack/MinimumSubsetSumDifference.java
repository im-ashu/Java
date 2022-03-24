package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumSubsetSumDifference {

  public static void main(String[] args) {
    int[] arr = {4, 5, 3, 7};
    int n = arr.length;
    System.out.println(minSubsetSumDiff(arr, n));
  }

  private static int minSubsetSumDiff(int[] arr, int n) {
    int min;
    int sum = Arrays.stream(arr).sum();
    int j = (int) Math.ceil(sum >> 1);
    boolean[][] t = subsetSum(arr, n, j);
    int maxFirstSubsetSum = Integer.MIN_VALUE;
    for (int i = 0; i <= j; i++) {
      if (t[n][i] && maxFirstSubsetSum < i) {
        maxFirstSubsetSum = i;
      }
    }
    min = sum - (2 * (maxFirstSubsetSum));
    return min;
  }

  private static boolean[][] subsetSum(int[] arr, int n, int sum) {
    boolean[][] t = new boolean[n + 1][sum + 1];
    IntStream.range(0, n + 1).forEach(row -> t[row][0] = true);
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
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