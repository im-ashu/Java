package com.datastructure.binarysearch;

public class FindPositionInInfiniteArray {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 5, 7, 9, 10, 90,
        100, 130, 140, 160, 170};
    int ans = findPos(arr, 170);

   if (ans == -1) {
    System.out.println("Element not found");
   } else {
    System.out.println("Element found at index " + ans);
   }
  }

  private static int findPos(int[] arr, int x) {
    int low = 0;
    int high = 1;
    while (arr[high] < x) {
      low = high;
      high = Math.min(high << 1, arr.length - 1);
    }
    return binarySearch(arr, low, high, x);
  }

  private static int binarySearch(int[] arr, int low, int high, int x) {
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] == x) {
        return mid;
      } else if (x < arr[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}