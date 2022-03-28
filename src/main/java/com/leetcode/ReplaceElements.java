package com.leetcode;

import java.util.Arrays;

public class ReplaceElements {

  public static void main(String[] args) {
    int[] arr = {17, 18, 5, 4, 6, 1};
    final int[] elements = replaceElements(arr);
    Arrays.stream(elements).mapToObj(element -> element + " ").forEach(System.out::print);

  }

  private static int[] replaceElements(int[] arr) {
    int n = arr.length;
    int[] res = new int[n];
    res[n - 1] = -1;
    int mxr = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      res[i] = mxr;
      mxr = Math.max(mxr, arr[i]);
    }
    return res;
  }
}