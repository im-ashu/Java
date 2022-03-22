package com.datastructure.array;

public class LargestElement {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 7, 3, 2, 4, 5};
    System.out.println(largest(arr, arr.length));
  }

  public static int largest(int[] arr, int n) {
    int max = Integer.MIN_VALUE;
    for (int e : arr) {
      if (e > max) {
        max = e;
      }
    }
    return max;
  }
}