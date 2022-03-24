package com.datastructure.slidingwindow;

import java.util.Arrays;

public class SlidingWindow {

  public static void main(String[] args) {
    int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
    int k = 4;
    int n = arr.length;
    System.out.println(maxSumInWindow(arr, n, k));
    System.out.println(maxSum(arr, n, k));
  }

  private static int maxSum(int[] arr, int n, int k) {
    if (k > n) {
      return -1;
    }
    int i = 0, j = 0;
    int maxSum = Integer.MIN_VALUE;
    int windowSum = 0;
    while (j < n) {
      windowSum += arr[j];
      if (j - i + 1 == k) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[i];
        i++;
      }
      j++;
    }
    return maxSum;
  }

  private static int maxSumInWindow(int[] arr, int n, int k) {
    int maxSum = Arrays.stream(arr, 0, Math.min(n, k)).sum();
    int windowSum = maxSum;
    for (int i = k; i < n; i++) {
      windowSum = windowSum - arr[i - k] + arr[i];
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }
}