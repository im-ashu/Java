package com.datastructure.binarysearch;

public class FindFloor {

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 6, 10, 12, 14};
    int n = arr.length;
    int x = 10;
    int index = floorSearch(
        arr, 0, n - 1,
        x);
    if (index == -1) {
      System.out.println(
          "Floor of " + x + " doesn't exist in array ");
    } else {
      System.out.println(
          "Floor of " + x + " is " + arr[index]);
    }
  }

  private static int floorSearch(int[] arr, int start, int end, int x) {
    int res = -1;
    while (start <= end) {
      int mid = start + ((end - start) >> 1);
      if (arr[mid] == x) {
        return mid;
      }
      if (arr[mid] < x) {
        res = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }
}