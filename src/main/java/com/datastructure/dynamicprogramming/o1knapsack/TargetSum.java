package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TargetSum {

  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 0, 0, 0, 2};
    int s = 2;
    int n = arr.length;
    System.out.println(targetSum(arr, n, s));
  }

  private static int targetSum(int[] arr, int n, int s) {
    int sum = Arrays.stream(arr).sum();
    int j = (sum + s) >> 1;
    if ((s > sum) && (((sum + s) % 2) != 0)) {
      return 0;
    }
    return subsetSum(arr, n, j);
  }

  private static int subsetSum(int[] arr, int n, int j) {
    int rowBound = n + 1;
    int colBound = j + 1;
    int[][] t = new int[rowBound][colBound];
    IntStream.range(0, colBound).forEach(col -> t[0][col] = 0);
    IntStream.range(0, rowBound).forEach(row -> t[row][0] = 1);
    for (int i = 1; i < rowBound; i++) {
      for (int k = 1; k < colBound; k++) {
        if (arr[i - 1] > j || arr[i - 1] == 0) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
        }
      }
    }
    int noOfZeroes = (int) IntStream.range(0, n).filter(i -> arr[i] == 0).count();
    return (int) (Math.pow(2, noOfZeroes) * t[n][j]);
  }
}