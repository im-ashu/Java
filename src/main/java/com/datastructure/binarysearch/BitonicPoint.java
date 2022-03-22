package com.datastructure.binarysearch;

public class BitonicPoint {

  public static void main(String[] args) {
    int[] arr = {12, 13, 14, 15, 16, 11, 12, 13, 14, 15, 16};
    System.out.println(findMaximum(arr, arr.length));
  }

  static int findMaximum(int[] arr, int n) {
    // code here
    int peakIndex = findPeak(arr, n);
    return arr[peakIndex];
  }

  private static int findPeak(int[] arr, int n) {
    int res = -1;
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (mid > 0 && mid < n - 1) {
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
          res = mid;
          break;
        } else if (arr[mid] < arr[mid - 1]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (mid == 0 && (arr[mid] > arr[mid + 1])) {
        res = mid;
        break;
      } else if (arr[mid] > arr[mid - 1]) {
        res = mid;
        break;
      }
    }
    return res;
  }
}
