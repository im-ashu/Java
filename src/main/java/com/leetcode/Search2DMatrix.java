package com.leetcode;

public class Search2DMatrix {

  public static void main(String[] args) {
    Search2DMatrix search2DMatrix = new Search2DMatrix();
    int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    int target = 3;
    System.out.println(search2DMatrix.searchMatrix(matrix, target));
    System.out.println(search2DMatrix.searchMatrixII(matrix, target));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int i = 0;
    int j = n - 1;
    while (j >= 0 && i < m) {
      if (matrix[i][j] == target) {
        return true;
      }
      if (matrix[i][j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }

  public boolean searchMatrixII(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0;
    int high = (m * n - 1);
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      int rowIndex = mid / n;
      int colIndex = mid % n;
      if (matrix[rowIndex][colIndex] == target) {
        return true;
      }
      if (matrix[rowIndex][colIndex] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }
}
