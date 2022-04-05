package com.leetcode;

public class SetMatrixZeroes {

  public static void main(String[] args) {
    SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
    int[][] matrix = {{1, 2, 0}};
    setMatrixZeroes.setZeroes(matrix);
    for (int[] rows : matrix) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(rows[j] + " ");
      }
      System.out.println();
    }
  }

  public void setZeroes(int[][] matrix) {
    boolean firstRowContainsZero = false;
    boolean firstColContainsZero = false;
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          if (j == 0) {
            firstRowContainsZero = true;
          }
          if (i == 0) {
            firstColContainsZero = true;
          } else {
            matrix[i][0] = 0;
            matrix[0][j] = 0;
          }
        }
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (firstRowContainsZero) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
    if (firstColContainsZero) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
  }
}
