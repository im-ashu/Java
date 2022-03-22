package com.datastructure.binarysearch;

public class PeakElement {

  public static void main(String[] args) {
    int[] arr = {3, 5, 3, 2, 0};
    int n = arr.length;
    System.out.println(
        "Index of a peak point is " + findPeak(arr, n));
  }

  private static int findPeak(int[] arr, int n) {
    return findPeakUtil(arr, 0, n - 1, n);
  }

  private static int findPeakUtil(int[] arr, int s, int h, int n) {
    int res = -1;
    while (s <= h) {
      int mid = s + ((h - s) >> 1);
      if (mid > 0 && mid < n - 1) {
        if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
          res = mid;
          break;
        } else if (arr[mid - 1] > arr[mid]) {
          h = mid;
        } else {
          s = mid + 1;
        }
      } else if (mid == 0 && arr[mid] > arr[mid + 1]) {
        res = mid;
        break;
      } else if (mid == n - 1 && arr[mid] > arr[mid - 1]) {
        res = mid;
        break;
      } else {
        break;
      }
    }
    return res;
  }
}