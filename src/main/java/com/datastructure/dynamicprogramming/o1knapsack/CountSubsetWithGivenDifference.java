package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountSubsetWithGivenDifference {

  public static void main(String[] args) {
    int[] arr = {1, 0};
    int difference = 1;
    int n = arr.length;
    System.out.println(countOfSubset(arr, n, difference));
  }

  private static int countOfSubset(int[] arr, int n, int difference) {
    int sum = Arrays.stream(arr).sum();
    if ((sum - difference) % 2 != 0) {
      return 0;
    }
    int subsetSum = (sum + difference) >> 1;
    return subsetSumProblem(arr, n, subsetSum);
  }

  private static int subsetSumProblem(int[] arr, int n, int subsetSum) {
    int[][] t = new int[n + 1][subsetSum + 1];
    IntStream.range(0, subsetSum + 1).forEach(col -> t[0][col] = 0);
    int bound = n + 1;
    for (int row = 0; row < bound; row++) {
      t[row][0] = 1;
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < subsetSum + 1; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][subsetSum];
  }
}