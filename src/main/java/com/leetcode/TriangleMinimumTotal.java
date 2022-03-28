package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class TriangleMinimumTotal {

  public static void main(String[] args) {
    List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4),
        Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));

    System.out.println(new TriangleMinimumTotal().minimumTotal(triangle));
    System.out.println(new TriangleMinimumTotal().minimumTotalTabulation(triangle));
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] t = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(t[i], -1);
    }
    return minimumTotalUtil(triangle, 0, 0, n, t);
  }

  private int minimumTotalUtil(List<List<Integer>> triangle, int i, int j, int n, int[][] t) {

    if (i == n - 1) {
      return triangle.get(i).get(j);
    }

    if (t[i][j] != -1) {
      return t[i][j];
    }

    int down = minimumTotalUtil(triangle, i + 1, j, n, t);
    int diagonalRight = minimumTotalUtil(triangle, i + 1, j + 1, n, t);

    return t[i][j] = triangle.get(i).get(j) + Math.min(down, diagonalRight);
  }

  public int minimumTotalTabulation(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] t = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        if (i == n - 1) {
          t[j] = triangle.get(i).get(j);
        } else {
          int down = t[j];
          int diagonalRight = t[j + 1];
          t[j] = triangle.get(i).get(j) + Math.min(down, diagonalRight);
        }
      }
    }
    return t[0];
  }

}
