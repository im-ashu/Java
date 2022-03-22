package com.datastructure.array;

public class FindTransitionPoint {

  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 1, 1};
    arr = new int[]{0, 0, 0, 0, 0};
    arr = new int[]{1, 1, 1, 1, 1};
    arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1};
    System.out.println(transitionPoint(arr, arr.length));
    System.out.println(firstOne(arr, arr.length));
  }

  static int transitionPoint(int[] arr, int n) {
    // code here
    int low = 0;
    int high = n - 1;
    int mid;
    while (low <= high) {
      mid = (low + high) / 2;
      if (arr[mid] < 1) {
        low = mid + 1;
      } else if (arr[mid] == 1) {
        if (mid - 1 < 0) {
          return 0;
        }
        if (arr[mid - 1] != 1) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  public static int firstOne(int[] arr, int n) {
    int low = 0;
    int high = n - 1;
    int res = -1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] == 1) {
        res = mid;
        high = mid - 1;
      } else if (arr[mid] < 1) {
        low = mid + 1;
      }
    }
    return res;
  }
}