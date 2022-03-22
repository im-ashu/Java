package com.datastructure.array;

public class SearchAnElementInASortedAndRotatedArray {

  public static void main(String[] args) {
    int[] arr = {8, 9, 1, 2, 3, 4, 5, 6, 7};
    int key = 6;
    int n = arr.length;
    int i = search(arr, 0, n - 1, key);
    if (i != -1) {
      System.out.printf("Element found at : %d%n", i);
    } else {
      System.out.println("Element not present");
    }
  }

  private static int search(int[] arr, int start, int end, int key) {
    if (start > end) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (arr[mid] == key) {
      return mid;
    }
    if (arr[start] <= arr[mid]) {
      if (key < arr[mid]) {
        return search(arr, start, mid - 1, key);
      }
      return search(arr, mid + 1, end, key);
    }
    if (key > arr[mid] && key <= arr[end]) {
      return search(arr, mid + 1, end, key);
    }
    return search(arr, start, mid - 1, key);
  }
}
