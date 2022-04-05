package com.leetcode;

import java.util.Arrays;

public class MinimumPathSum {

  public static void main(String[] args) {
    MinimumPathSum minimumPathSum = new MinimumPathSum();
    int[][] grid = {{1, 2, 3}, {4, 5, 6}};
    System.out.println(minimumPathSum.minPathSum(grid));
  }

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] t = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(t[i], -1);
    }
    return minPathSumUtil(grid, m - 1, n - 1, t);
  }

  private int minPathSumUtil(int[][] grid, int i, int j, int[][] t) {
    if (i < 0 || j < 0) {
      return (int) 1e9;
    }
    if (i == 0 && j == 0) {
      return grid[i][j];
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    int up = minPathSumUtil(grid, i - 1, j, t);
    int left = minPathSumUtil(grid, i, j - 1, t);
    return t[i][j] = grid[i][j] + Math.min(up, left);
  }
}
