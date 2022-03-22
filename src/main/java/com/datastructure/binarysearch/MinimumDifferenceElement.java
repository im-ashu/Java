package com.datastructure.binarysearch;

public class MinimumDifferenceElement {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 5, 7, 9, 10, 90,
        100, 130, 140, 160, 170};
    int key = 145;
    int res = minDifference(arr, key);
    System.out.println(res);
  }

  private static int minDifference(int[] arr, int key) {
    int low = 0, high = arr.length - 1;
    int ceil = -1;
    int floor = -1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] == key) {
        return arr[mid];
      } else if (arr[mid] > key) {
        ceil = arr[mid];
        high = mid - 1;
      } else {
        floor = arr[mid];
        low = mid + 1;
      }
    }
    if (key - floor < ceil - key) {
      return floor;
    }
    return ceil;
  }
}