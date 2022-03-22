package com.datastructure.binarysearch;

public class SearchIn2DSortedArray {

  public static void main(String[] args) {
    int[][] mat = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}};
    int n = mat.length;
    int key = 29;
    search(mat, n, key);
  }

  private static void search(int[][] mat, int n, int key) {
    int j = n - 1, i = 0;
    while (i < n && j >= 0) {
      if (mat[i][j] == key) {
        System.out.println("Element found at row: " + i + ", column: " + j);
        return;
      } else if (mat[i][j] > key) {
        j--;
      } else {
        i++;
      }
    }
    System.out.println("Element not found");
  }
}