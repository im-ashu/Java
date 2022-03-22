package com.codestudio;

import java.util.Arrays;

public class TotalUniquePaths {

  public static void main(String[] args) {
    int m = 3;
    int n = 3;
    System.out.print(uniquePaths(m, n));
  }

  public static int uniquePaths(int m, int n) {
    // Write your code here.
    int[][] t = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(t[i], -1);
    }
    return uniquePaths(m - 1, n - 1, t);
  }

  public static int uniquePaths(int i, int j, int[][] t) {
    if (i < 0 || j < 0) {
      return 0;
    }
    if (i == 0 && j == 0) {
      return 1;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    int up = 0;
    if (i > 0) {
      if (t[i - 1][j] != -1) {
        up = t[i - 1][j];
      } else {
        up = uniquePaths(i - 1, j, t);
        t[i - 1][j] = up;
      }
    }

    int left = 0;
    if (j > 0) {
      if (t[i][j - 1] != -1) {
        left = t[i][j - 1];
      } else {
        left = uniquePaths(i, j - 1, t);
        t[i][j - 1] = left;
      }
    }
    return t[i][j] = (up + left);
  }
}