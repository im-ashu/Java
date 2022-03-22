package com.datastructure.binarysearch;

import java.util.Arrays;

public class AllocateMinimumNumberPages {

  public static void main(String[] args) {
    int[] arr = {97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1,
        53, 8, 44, 68, 90, 24};

    int m = 26; //No. of students

    System.out.println("Minimum number of pages = " +
        findPages(arr, arr.length, m));
  }

  private static int findPages(int[] arr, int n, int m) {
    int low = Arrays.stream(arr).max().orElse(0);
    int high = Arrays.stream(arr).sum();
    int res = -1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (isPossible(arr, n, m, mid)) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
  }

  private static boolean isPossible(int[] arr, int n, int m, int sum) {
    int currSum = 0;
    int studentsRequired = 1;
    for (int i = 0; i < n; i++) {
      if (currSum + arr[i] > sum) {
        studentsRequired++;
        currSum = arr[i];
        if (studentsRequired > m) {
          return false;
        }
      } else {
        currSum += arr[i];
      }
    }
    return true;
  }
}