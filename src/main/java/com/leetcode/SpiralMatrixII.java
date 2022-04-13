package com.leetcode;

public class SpiralMatrixII {

  public static void main(String[] args) {
    SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
    int n = 20;
    int[][] matrix = spiralMatrixII.generateMatrix(n);
    for (int[] rows : matrix) {
      for (int ele : rows) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int n1 = n - 1;
    n *= n;
    int gap = 0;
    int count = 1;
    while (count <= n) {
      int row = gap;
      int col = gap;
      while (col <= n1 - gap) {
        matrix[row][col++] = count++;
      }
      row++;
      col--;
      while (row <= n1 - gap) {
        matrix[row++][col] = count++;
      }
      col--;
      row--;
      while (col >= gap) {
        matrix[row][col--] = count++;
      }
      row--;
      col++;
      while (row > gap) {
        matrix[row--][col] = count++;
      }
      gap++;
    }
    return matrix;
  }

}
