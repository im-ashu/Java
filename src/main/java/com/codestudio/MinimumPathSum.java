package com.codestudio;

public class MinimumPathSum {

  public static void main(String[] args) {
    int[][] grid = {
        {8, 1, 6},
        {4, 4, 16},
        {2, 7, 20},
        {20, 7, 20}};
    System.out.println(minSumPath(grid));
  }

  public static int minSumPath(int[][] grid) {
    // Write your code here.
    int n = grid.length;
    int m = grid[0].length;
    int[] prev = new int[m];
    long M = 1000000007;
    for (int i = 0; i < n; i++) {
      int[] curr = new int[m];
      for (int j = 0; j < m; j++) {
        if (i == 0 && j == 0) {
          curr[j] = grid[i][j];
        } else {
          int up = grid[i][j];
          if (i > 0) {
            up += prev[j];
          } else {
            up += M;
          }
          int left = grid[i][j];
          if (j > 0) {
            left += curr[j - 1];
          } else {
            left += M;
          }
          curr[j] = Math.min(up, left);
        }
      }
      prev = curr;
    }
    return prev[m - 1];
  }
}