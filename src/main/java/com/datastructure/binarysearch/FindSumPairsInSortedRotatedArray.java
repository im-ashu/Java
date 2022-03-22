package com.datastructure.binarysearch;

public class FindSumPairsInSortedRotatedArray {

  public static void main(String[] args) {
    int[] arr = {12, 6, 8, 9, 10, 11};
    int sum = 12;
    int n = arr.length;

   if (pairInSortedRotated(arr, n, sum)) {
    System.out.print("Array has two elements" +
        " with sum 16");
   } else {
    System.out.print("Array doesn't have two" +
        " elements with sum 16 ");
   }
  }

  private static boolean pairInSortedRotated(int[] arr, int n, int sum) {
    int pivotIndex = findPivot(arr, 0, n - 1);
    int low, high;
    low = pivotIndex + 1;
    high = (n + low - 1) % n;/* < 0 ? n - 1 : low - 1;*/
    while (low != high) {
      if (sum == (arr[low] + arr[high])) {
        return true;
      }
      if (sum > (arr[low] + arr[high])) {
        low = (low + 1) % n;
      } else if (sum < (arr[low] + arr[high])) {
        high = (n + high - 1) % n;
      }
    }
    return false;
  }

  private static int findPivot(int[] arr, int low, int high) {
   if (high < low) {
    return -1;
   }
   if (high == low) {
    return low;
   }
    int mid = (low + high) / 2;
    if (mid < high && arr[mid + 1] < arr[mid]) {
      return mid;
    }
    if (mid > low && arr[mid] < arr[mid - 1]) {
      return mid - 1;
    }
    if (arr[high] > arr[mid]) {
      return findPivot(arr, low, mid - 1);
    }
    return findPivot(arr, mid + 1, high);
  }

}