package com.leetcode;

import java.util.Arrays;

public class UniquePaths {

  public static void main(String[] args) {
    UniquePaths uniquePaths = new UniquePaths();
    int m = 3, n = 7;
    System.out.println(uniquePaths.uniquePaths(m, n));

  }

  public int uniquePaths(int m, int n) {
    int[][] t = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(t[i], -1);
    }
    return uniquePathsUtil(m - 1, n - 1, t);
  }

  private int uniquePathsUtil(int i, int j, int[][] t) {
    if (i < 0 || j < 0) {
      return 0;
    }
    if (i == 0 && j == 0) {
      return 1;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    int up = uniquePathsUtil(i - 1, j, t);
    int left = uniquePathsUtil(i, j - 1, t);
    return t[i][j] = up + left;
  }

}
