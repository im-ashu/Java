package com.gfg;

import java.util.HashMap;

public class SubarrayXor {

  public static void main(String[] args) {
    int[] arr = {5, 6, 7, 8, 9};
    int n = arr.length;
    int m = 5;

    System.out.println(subarrayXor(arr, m));
    System.out.println(subarrayXorBruteForce(arr, n, m));
  }

  static long subarrayXor(int[] arr, int m) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int xor = 0;
    long count = 0;
    for (int num : arr) {
      xor ^= num;
      int Y = xor ^ m;
      if (map.containsKey(Y)) {
        count += map.get(Y);
      }
      map.put(xor, map.getOrDefault(xor, 0) + 1);
    }
    return count;
  }

  static long subarrayXorBruteForce(int[] arr, int n, int m) {
    long count = 0;
    for (int i = 0; i < n; i++) {
      int xor = 0;
      for (int j = i; j < n; j++) {
        xor ^= arr[j];
        if (xor == m) {
          count++;
        }
      }
    }
    return count;
  }

}
