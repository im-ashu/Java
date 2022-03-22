package com.datastructure.binarysearch;

public class PosOfFirstOne {

  public static void main(String[] args) {
    int[] arr = {0, 0, 1, 1, 1, 1};
    System.out.println("Index = " +
        posOfFirstOne(arr));
  }

  private static int posOfFirstOne(int[] arr) {
    int low = 0;
    int high = 1;
    while (arr[high] < 1) {
      low = high;
      high = Math.min(high << 1, arr.length - 1);
    }
    return findFirstPos(arr, low, high, 1);
  }

  private static int findFirstPos(int[] arr, int low, int high, int x) {
    int res = -1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] == x) {
        res = mid;
        high = mid - 1;
      } else if (x > arr[mid]) {
        low = mid + 1;
      }
    }
    return res;
  }
}