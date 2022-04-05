package com.leetcode;

import java.util.Arrays;

public class UniquePathsII {

  public static void main(String[] args) {
    UniquePathsII uniquePathsII = new UniquePathsII();
    int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid));
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] t = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(t[i], -1);
    }
    return uniquePathsWithObstaclesUtil(obstacleGrid, m - 1, n - 1, t);
  }

  private int uniquePathsWithObstaclesUtil(int[][] obstacleGrid, int i, int j, int[][] t) {
    if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
      return 0;
    }
    if (i == 0 && j == 0) {
      return 1;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    int up = uniquePathsWithObstaclesUtil(obstacleGrid, i - 1, j, t);
    int left = uniquePathsWithObstaclesUtil(obstacleGrid, i, j - 1, t);
    return t[i][j] = up + left;
  }
}
