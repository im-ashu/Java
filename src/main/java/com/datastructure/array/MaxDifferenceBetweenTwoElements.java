package com.datastructure.array;

public class MaxDifferenceBetweenTwoElements {

  public static void main(String[] args) {
    int[] arr = {1, 2, 90, 10, 110};
    int size = arr.length;
    System.out.println("MaximumDifference is " +
        maxDiff(arr, size));
  }

  private static int maxDiff(int[] arr, int size) {
    if (size == 0) {
      return Integer.MIN_VALUE;
    }
    if (size > 1) {
      int maxDifference = arr[1] - arr[0];
      int minElement = arr[0];
      for (int i = 1; i < size; i++) {
        if (arr[i] - minElement > maxDifference) {
          maxDifference = arr[i] - minElement;
        }
        if (arr[i] < minElement) {
          minElement = arr[i];
        }
      }
      return maxDifference;
    }
    return Integer.MIN_VALUE;
  }
}