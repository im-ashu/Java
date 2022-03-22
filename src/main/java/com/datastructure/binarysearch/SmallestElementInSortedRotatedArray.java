package com.datastructure.binarysearch;

public class SmallestElementInSortedRotatedArray {

  public static void main(String[] args) {
    int[] arr = {12, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    int smallest = findMin(arr, 0, arr.length - 1);
    System.out.println(smallest);
  }

  private static int findMin(int[] arr, int low, int high) {
   if (high < low) {
    return arr[0];
   }
    if (high == low) {
      return arr[low];
    }
    int mid = (low + high) / 2;
    if (mid < high && arr[mid + 1] < arr[mid]) {
      return arr[mid + 1];
    }
    if (mid > low && arr[mid] < arr[mid - 1]) {
      return arr[mid];
    }
    if (arr[high] > arr[mid]) {
      return findMin(arr, low, mid - 1);
    }
    return findMin(arr, mid + 1, high);
  }
}