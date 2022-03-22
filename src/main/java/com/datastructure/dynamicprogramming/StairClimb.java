package com.datastructure.dynamicprogramming;

public class StairClimb {

  public static void main(String[] args) {
    int n = 4;
    System.out.println(countPathsTab(n));
    System.out.println(minPathsTab(n));
  }

  private static int countPathsTab(int n) {
    int[] t = new int[n + 1];
    t[0] = 1;
    t[1] = t[0];
    for (int i = 2; i <= n; i++) {
      if (i - 4 >= 0) {
        t[i] = t[i - 1] + t[i - 2] + t[i - 3];
      } else {
        t[i] = t[i - 1] + t[i - 2];
      }
    }
    return t[n];
  }

  private static int minPathsTab(int n) {
    int[] t = new int[n + 1];
    t[0] = 0;
    t[1] = 1 + t[0];
    for (int i = 2; i <= n; i++) {
      if (i - 3 >= 0) {
        t[i] = 1 + min(t[i - 1], t[i - 2], t[i - 3]);
      } else {
        t[i] = 1 + min(t[i - 1], t[i - 2]);
      }
    }
    return t[n];
  }

  private static int min(int... numbers) {
    int min = Integer.MAX_VALUE;
    for (int number : numbers) {
      min = Math.min(number, min);
    }
    return min;
  }
}