package com.datastructure.binarysearch;

public class FindPivotInSortedRotatedArray {

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2};
    // arr = new int[] { 8, 9, 10, 11, 12 };
    System.out.println(findPivot(arr, 0, arr.length - 1, arr.length));
  }

  private static int findPivot(int[] arr, int low, int high, int N) {
    if (high < low) {
      return arr[0];
    }
    int mid = ((high - low) >> 1) + low;
    int prev = (mid - 1 + N) % N;
    int next = (mid + 1) % N;
    if (arr[mid] < arr[next] && arr[mid] < arr[prev]) {
      return arr[mid];
    }
    if (arr[high] > arr[mid]) {
      return findPivot(arr, low, mid - 1, N);//Always follow the Unsorted Half
    }
    return findPivot(arr, mid + 1, high, N);//Always follow the Unsorted Half
  }
}