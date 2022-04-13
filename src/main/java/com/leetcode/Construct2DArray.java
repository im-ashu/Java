package com.leetcode;

public class Construct2DArray {

  public static void main(String[] args) {
    Construct2DArray construct2DArray = new Construct2DArray();
    int[] original = {1, 2, 3, 4};
    int m = 2;
    int n = 2;
    int[][] twoDArray = construct2DArray.construct2DArray(original, m, n);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(twoDArray[i][j] + " ");
      }
      System.out.println();
    }
  }

  public int[][] construct2DArray(int[] original, int m, int n) {
    int[][] tDArray = new int[0][];
    int len = original.length;
    if (m * n == len) {
      tDArray = new int[m][n];
      for (int i = 0; i < len; i++) {
        tDArray[i / n][i % n] = original[i];
      }
    }
    return tDArray;
  }
}
