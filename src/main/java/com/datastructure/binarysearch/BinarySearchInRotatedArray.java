package com.datastructure.binarysearch;

public class BinarySearchInRotatedArray {

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2};
    int key = 3;
    int indexedSearch = search(arr, 0, arr.length - 1, key);
    System.out.println((indexedSearch != -1) ? ("Found at " + indexedSearch) : "Not Found");
  }

  private static int search(int[] arr, int low, int high, int key) {
    if (high < low) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (arr[mid] == key) {
      return mid;
    }
    if (arr[low] <= arr[mid]) {
      if (key >= arr[low] && key <= arr[mid]) {
        return search(arr, low, mid - 1, key);
      }
      return search(arr, mid + 1, high, key);
    }
    if (key >= arr[mid] && key <= arr[high]) {
      return search(arr, mid + 1, high, key);
    }
    return search(arr, low, mid - 1, key);
  }
}