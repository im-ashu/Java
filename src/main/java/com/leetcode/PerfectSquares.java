package com.leetcode;

public class PerfectSquares {

  public static void main(String[] args) {
    int n = 12;
    System.out.println(new PerfectSquares().numSquares(n));
  }

  public int numSquares(int n) {
    int[] t = new int[n + 1];
    t[0] = 0;
    t[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        int rem = i - (j * j);
        if (t[rem] < min) {
          min = t[rem];
        }
      }
      t[i] = 1 + min;
    }
    return t[n];
  }
}
