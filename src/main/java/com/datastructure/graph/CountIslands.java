package com.datastructure.graph;

public class CountIslands {

  public static void main(String[] args) {
 /*int[][] arr = {
 { 0, 0, 1, 1, 1, 1, 1, 1 },
 { 0, 0, 1, 1, 1, 1, 1, 1 },
 { 1, 1, 1, 1, 1, 1, 1, 0 },
 { 1, 1, 0, 0, 0, 1, 1, 0 },
 { 1, 1, 1, 1, 0, 1, 1, 0 },
 { 1, 1, 1, 1, 0, 1, 1, 0 },
 { 1, 1, 1, 1, 1, 1, 1, 0 },
 { 1, 1, 1, 1, 1, 1, 1, 0 } };*/

    int[][] arr = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1}
    };

    int row = arr.length;
    int col = arr[0].length;
    boolean[][] visited = new boolean[row][col];
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] == 0 && !visited[i][j]) {
          drawTreeAndGenerateComponent(arr, i, j, visited);
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private static void drawTreeAndGenerateComponent(int[][] arr, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1
        || visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    drawTreeAndGenerateComponent(arr, i - 1, j, visited);
    drawTreeAndGenerateComponent(arr, i, j - 1, visited);
    drawTreeAndGenerateComponent(arr, i + 1, j, visited);
    drawTreeAndGenerateComponent(arr, i, j + 1, visited);
  }
}