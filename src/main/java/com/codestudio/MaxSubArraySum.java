package com.codestudio;

public class MaxSubArraySum {

  public static void main(String[] args) {
    int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};
    int n = arr.length;
    System.out.println(maxSubArraySum(arr, n));
  }

  public static long maxSubArraySum(int[] arr, int n) {
    // write your code here
    int maxSoFar = arr[0];
    int maxEndingHere = arr[0];
    for (int i = 1; i < n; i++) {
      maxEndingHere += arr[i];
      if (maxEndingHere < arr[i]) {
        maxEndingHere = arr[i];
      }
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }
}
