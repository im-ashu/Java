package com.datastructure.array;

public class KadaneAlgorithm {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, -2, 5};
    arr = new int[]{-4, -2, -3, -4};
    System.out.println(maxSubarraySum(arr, arr.length));
  }

  static long maxSubarraySum(int[] arr, int n) {

    // Your code here
    int maxSoFar = arr[0];
    int maxEndingHere = arr[0];
    for (int i = 1; i < n; i++) {
      maxEndingHere += arr[i];
      if (maxEndingHere < arr[i]) {
        maxEndingHere = arr[i];
      }
      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
      }

    }
    return maxSoFar;
  }
}