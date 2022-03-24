package com.datastructure.array;

import java.util.Arrays;
import java.util.HashSet;

public class FindPythagoreanTriplet {

  public static void main(String[] args) {
    int[] arr = {3, 2, 4, 6, 5};
    int n = arr.length;
    if (checkTriplet(arr, n)) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }

  private static boolean checkTriplet(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] * arr[i];
    }
    Arrays.sort(arr);
    for (int i = n - 1; i - 2 >= 0; i--) {
      HashSet<Integer> hs = new HashSet<>();
      for (int j = i - 1; j > 0; j--) {
        int x = (arr[i] - arr[j]);
        if (hs.contains(x)) {
          return true;
        } else {
          hs.add(arr[j]);
        }
      }
    }
    return false;
  }
}