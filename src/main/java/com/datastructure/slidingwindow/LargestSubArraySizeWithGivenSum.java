package com.datastructure.slidingwindow;

public class LargestSubArraySizeWithGivenSum {

  public static void main(String[] args) {
// int[] arr = { 4, 1, 1, 1, 2, 3, 5 };
    int[] arr = {7, 2, 5};
    int n = arr.length;
    int sum = 5;
    System.out.println(largestSubArray(arr, n, sum));
  }

  private static int largestSubArray(int[] arr, int n, int K) {
    int i = 0, j = 0;
    int size = Integer.MIN_VALUE;
    int sum = 0;
    while (i < n && j < n) {
      sum += arr[j];
      if (sum == K) {
        size = Math.max(size, j - i + 1);
      }
      while (sum > K) {
        sum -= arr[i];
        i++;
        if (sum == K) {
          size = Math.max(size, j - i + 1);
        }
      }
      j++;
    }
    return size;
  }
}