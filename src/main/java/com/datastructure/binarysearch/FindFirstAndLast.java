package com.datastructure.binarysearch;

public class FindFirstAndLast {

  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
    int x = 2;
    findFirstAndLast(arr, x);
  }

  private static void findFirstAndLast(int[] arr, int x) {
    int last, first;
    System.out.println((first = findFirst(arr, x)));
    System.out.println(last = findLast(arr, x));
    System.out.println("Count = " + (last - first + 1));
  }

  private static int findLast(int[] arr, int x) {
    int low = 0;
    int high = arr.length - 1;
    int res = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == x) {
        res = mid;
        low = mid + 1;
      } else if (x > arr[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }

  private static int findFirst(int[] arr, int x) {
    int low = 0;
    int high = arr.length - 1;
    int res = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == x) {
        res = mid;
        high = mid - 1;
      } else if (x > arr[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }
}