package com.hackerrank.dynamicprogramming;

public class MaxArraySum {

  public static void main(String[] args) {
    int[] arr = {-2, -3, -1, -5};
    System.out.println(maxSubsetSum(arr));
  }

  static int maxSubsetSum(int[] arr) {
    int n = arr.length;
    Integer[] t = new Integer[n + 1];
    return Math.max(maxSubsetSumUtil(arr, n - 1, t), 0);
  }

  private static int maxSubsetSumUtil(int[] arr, int i, Integer[] t) {
    if (i == 0) {
      return arr[0];
    }
    if (i < 0) {
      return 0;
    }
    if (t[i] != null) {
      return t[i];
    }
    int notPick = maxSubsetSumUtil(arr, i - 1, t);
    int pick = arr[i] + maxSubsetSumUtil(arr, i - 2, t);
    return t[i] = Math.max(pick, notPick);
  }

  static int maxSubSetSumTab(int[] arr) {
    int n = arr.length;
    int prev = Math.max(arr[0], 0);
    int prev2 = 0;
    for (int i = 1; i < n; i++) {
      int current = Math.max(prev, arr[i] + prev2);
      prev2 = prev;
      prev = current;
    }
    return prev;
  }
}
