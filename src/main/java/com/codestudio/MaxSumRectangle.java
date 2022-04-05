package com.codestudio;

public class MaxSumRectangle {

  public static void main(String[] args) {
    int[][] arr = {{1, 2, -1, -4, -20}, {-8, -3, 4, 2, 1}, {3, 8, 10, 1, 3}, {-4, -1, 1, 7, -6}};
    int n = arr.length;
    int m = arr[0].length;
    System.out.println(maxSumRectangle(arr, n, m));
  }

  public static int maxSumRectangle(int[][] arr, int n, int m) {
    // Write your code here.
    /*int leftBound = 0;
    int rightBound = 0;
    int upBound = 0;
    int downBound = 0;*/
    int maxSum = 0;
    int[] temp = new int[n];
    for (int left = 0; left < m; left++) {
      for (int i = 0; i < n; i++) {
        temp[i] = 0;
      }
      for (int right = left; right < m; right++) {
        for (int i = 0; i < n; i++) {
          temp[i] += arr[i][right];
        }
        KadaneResult kadane = new KadaneResult();
        kadane.result(temp);
        if (kadane.maxSum > maxSum) {
          maxSum = kadane.maxSum;
          /*leftBound = left;
          rightBound = right;
          upBound = kadane.start;
          downBound = kadane.end;*/
        }
      }
    }
    return maxSum;
  }

  static class KadaneResult {

    int maxSum;
    int start;
    int end;

    void result(int[] arr) {
      int n = arr.length;
      int s = 0;
      int maxEndingHere = arr[0];
      maxSum = arr[0];
      for (int i = 1; i < n; i++) {
        maxEndingHere += arr[i];
        if (maxEndingHere < arr[i]) {
          maxEndingHere = arr[i];
          s = i;
        }
        if (maxSum < maxEndingHere) {
          end = i;
          start = s;
          maxSum = maxEndingHere;
        }
      }
    }
  }
}
