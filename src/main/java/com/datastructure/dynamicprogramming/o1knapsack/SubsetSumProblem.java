package com.datastructure.dynamicprogramming.o1knapsack;

import java.util.ArrayDeque;
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
          t[i][j] = (t[i - 1][j - arr[i - 1]]) || (t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    printSubsets(t, arr, sum);
    return t[n][sum];
  }

  private static void printSubsets(boolean[][] t, int[] arr, int sum) {
    int n = arr.length;
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(n, sum, ""));
    while (!queue.isEmpty()) {
      Pair rem = queue.remove();
      if (rem.i == 0 || rem.j == 0) {
        System.out.println(rem.psf.substring(0, rem.psf.length() - 2));
        continue;
      }
      if (rem.j >= arr[rem.i - 1] && t[rem.i - 1][rem.j - arr[rem.i - 1]]) {
        queue.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], arr[rem.i - 1] + "->" + rem.psf));
      }
      if (t[rem.i - 1][rem.j]) {
        queue.add(new Pair(rem.i - 1, rem.j, rem.psf));
      }
    }
  }

  static class Pair {

    int i;
    int j;
    String psf;

    public Pair(int i, int j, String psf) {
      this.i = i;
      this.j = j;
      this.psf = psf;
    }
  }
}