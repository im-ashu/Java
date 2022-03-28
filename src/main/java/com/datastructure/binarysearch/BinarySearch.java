package com.datastructure.binarysearch;

public class BinarySearch {

  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10};
    int key = 7;
    final int minEleIndex = findMinInSortedArray(arr, 0, arr.length - 1);
    final int bsResult1 = binarySearch(arr, key, 0, minEleIndex - 1);
    final int bsResult2 = binarySearch(arr, key, minEleIndex, arr.length - 1);
    int index = bsResult1 != -1 ? bsResult1 : bsResult2;
    System.out.println("Element " + (index == -1 ? "Not " : "") + "found " + (index == -1 ? ""
        : "at index = " + index));
  }

  private static int findMinInSortedArray(int[] arr, int start, int end) {
    if (start > end) {
      return 0;
    }
    if (start == end) {
      return start;
    }
    int mid = start + ((end - start) >> 1);
    if (end > mid && arr[mid + 1] < arr[mid]) {
      return mid + 1;
    }
    if (start < mid && arr[mid] < arr[mid - 1]) {
      return mid;
    }
    if (arr[end] > arr[mid]) {
      return findMinInSortedArray(arr, start, mid - 1);
    }
    return findMinInSortedArray(arr, mid + 1, end);
  }

  private static int binarySearch(int[] arr, int key, int start, int end) {
    if (start > end) {
      return -1;
    }
    int mid = start + ((end - start) >> 1);
    if (arr[mid] == key) {
      return mid;
    } else if (arr[mid] < key) {
      return binarySearch(arr, key, mid + 1, end);
    }
    return binarySearch(arr, key, start, mid - 1);
  }
}