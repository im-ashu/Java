package com.codestudio;

import java.util.ArrayList;

public class MaximumSubarray {

  public static void main(String[] args) {
    int[] arr = {-1, -2, -55};
    int n = arr.length;
    maximumsumSubarray(n, arr);
  }

  public static ArrayList<Integer> maximumsumSubarray(int n, int[] arr) {
    // Write your code here
    int maxEndingHere = arr[0];
    int maxSoFar = arr[0];
    int start = 0, s = 0;
    int end = 0;
    for (int i = 1; i < n; i++) {
      maxEndingHere += arr[i];
      if (maxEndingHere < arr[i]) {
        s = i;
        maxEndingHere = arr[i];
      }
      if (maxSoFar <= maxEndingHere) {
        end = i;
        start = s;
        maxSoFar = maxEndingHere;
      }
    }
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = start; i < end + 1; i++) {
      res.add(arr[i]);
    }
    return res;
  }
}