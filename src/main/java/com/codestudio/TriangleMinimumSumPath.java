package com.codestudio;

import java.util.Arrays;

public class TriangleMinimumSumPath {

  public static void main(String[] args) {
    int[][] triangle = {
        {1},
        {2, 3},
        {3, 6, 7},
        {8, 9, 6, 10}};
    int n = triangle.length;
    int[][] t = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(t[i], -1);
    }
    System.out.println(minSumPath(triangle, 0, 0, t));
    System.out.println(minimumPathSum(triangle, n));
  }

  public static int minimumPathSum(int[][] triangle, int n) {
    // Write your code here.
    int[][] t = new int[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j >= 0; j--) {
        if (i == n - 1) {
          t[i][j] = triangle[i][j];
        } else {
          int down = triangle[i][j] + t[i + 1][j];
          int diagonal = triangle[i][j] + t[i + 1][j + 1];
          t[i][j] = Math.min(down, diagonal);
        }
      }
    }
    return t[0][0];
  }

  private static int minSumPath(int[][] triangle, int i, int j, int[][] t) {

    if (i > triangle.length || j > i + 1) {
      return 0;
    }
    if (i == triangle.length - 1) {
      return triangle[i][j];
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    int down = triangle[i][j] + minSumPath(triangle, i + 1, j, t);
    int diagonal = triangle[i][j] + minSumPath(triangle, i + 1, j + 1, t);
    return t[i][j] = Math.min(down, diagonal);
  }
}
