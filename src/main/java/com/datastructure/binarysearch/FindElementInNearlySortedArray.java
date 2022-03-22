package com.datastructure.binarysearch;

public class FindElementInNearlySortedArray {

  public static void main(String[] args) {
    int[] arr = {3, 2, 10, 4, 40};
    int n = arr.length;
    int x = 4;
    int result = binarySearch(arr, 0, n - 1, x);
   if (result == -1) {
    System.out.println("Element is not present in array");
   } else {
    System.out.println("Element is present at index " +
        result);
   }
  }

  private static int binarySearch(int[] arr, int start, int end, int x) {
    if (start > end) {
      return -1;
    }
    int mid = start + ((end - start) >> 1);
    if (arr[mid] == x) {
      return mid;
    }
    if (start < mid && arr[mid - 1] == x) {
      return mid - 1;
    }
    if (mid < end && arr[mid + 1] == x) {
      return mid + 1;
    }
    if (x < arr[mid]) {
      return binarySearch(arr, start, mid - 2, x);
    }
    return binarySearch(arr, mid + 2, end, x);
  }
}