package com.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Fib {

  public static void main(String[] args) {
    int n = 5;
    for (int i = 1; i <= n; i++) {
      System.out.printf("%d ", fibRec(i));
    }
    System.out.println();
    for (int i = 1; i <= n; i++) {
      System.out.printf("%d ", fibDPBottomUp(i));
    }
  }

  public static int fibRec(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }
    return fibRec(n - 1) + fibRec(n - 2);
  }

  public static int fibDPBottomUp(int n) {
    int[] arr = new int[n];
    arr[0] = 1;
    int total;
    Set<Integer> set = new HashSet<>(Arrays.asList(1, 2));
    for (int i = 1; i < arr.length; i++) {
      total = 0;
      for (int j : set) {
        if (i - j >= 0) {
          total += arr[i - j];
        }
      }
      arr[i] = total;
    }
    return arr[n - 1];
  }

}
