package com.leetcode;

import java.util.Arrays;

public class Search2DMatrixII {

  public static void main(String[] args) {
    Search2DMatrixII search2DMatrixII = new Search2DMatrixII();
    int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
    int target = 5;
    System.out.println(search2DMatrixII.searchMatrix(matrix, target));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] rows : matrix) {
      int index = Arrays.binarySearch(rows, target);
      if (index >= 0) {
        return true;
      }
    }
    return false;
  }

}
