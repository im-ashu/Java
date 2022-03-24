package com.datastructure.binarysearch;

public class FindCeil {

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 6, 10, 12, 14};
    int n = arr.length;
    int x = 13;
    int index = ceilSearch(
        arr, 0, n - 1,
        x);
    if (index == -1) {
      System.out.println(
          "Ceil of " + x + " doesn't exist in array ");
    } else {
      System.out.println(
          "Ceil of " + x + " is " + arr[index]);
    }
  }

  private static int ceilSearch(int[] arr, int start, int end, int x) {
    int res = -1;
    while (start <= end) {
      int mid = start + ((end - start) >> 1);
      if (arr[mid] == x) {
        return mid;
      } else if (arr[mid] > x) {
        end = mid - 1;
        res = mid;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }
}