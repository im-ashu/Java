package com.codestudio;

import java.util.Arrays;

public class MaximumFallingPathSum {

  public static void main(String[] args) {
    int[][] matrix = {{-9999, -9888, -9777, -9666, -9555}, {1, 10, 2, 4, 5},
        {-9999, -9888, -9777, -9666, -9555}, {0, 0, 0, 0, 0}, {-99, -98, -97, -96, -95}};
    System.out.println(getMaxPathSum(matrix));
  }

  public static int getMaxPathSum(int[][] matrix) {
    // Write your code here
    int n = matrix.length;
    int m = matrix[0].length;
    int max = Integer.MIN_VALUE;
    int[][] t = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(t[i], 1000000009);
    }
    for (int i = 0; i < m; i++) {
      max = Math.max(max, getMaxPathSum(0, i, matrix, t));
    }
    return max;
  }

  private static int getMaxPathSum(int i, int j, int[][] matrix, int[][] t) {
    if (i >= matrix.length || j >= matrix[0].length || j < 0) {
      return Integer.MIN_VALUE;
    }
    if (i == matrix.length - 1) {
      return matrix[i][j];
    }
    if (t[i][j] != 1000000009) {
      return t[i][j];
    }
    int down = getMaxPathSum(i + 1, j, matrix, t);
    int diagonalLeft = getMaxPathSum(i + 1, j - 1, matrix, t);
    int diagonalRight = getMaxPathSum(i + 1, j + 1, matrix, t);
    return t[i][j] = matrix[i][j] + Math.max(down, Math.max(diagonalLeft, diagonalRight));
  }
}
