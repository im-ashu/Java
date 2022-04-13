package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

  public static void main(String[] args) {
    Shift2DGrid shift2DGrid = new Shift2DGrid();
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int k = 1;
    List<List<Integer>> shiftedGrid = shift2DGrid.shiftGrid(grid, k);
    for (List<Integer> rows : shiftedGrid) {
      for (Integer element : rows) {
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int eleTotal = m * n;
    k = k % (eleTotal);
    k = eleTotal - k;
    List<List<Integer>> shiftedGrid = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      shiftedGrid.add(new ArrayList<>());
    }
    int[] arr = new int[eleTotal];
    int index = 0;
    for (int[] rows : grid) {
      for (int j = 0; j < grid[0].length; j++) {
        arr[index++] = rows[j];
      }
    }

    int d = gcd(eleTotal, k);
    for (int i = 0; i < d; i++) {
      int temp = arr[i];
      int j = i;
      while (true) {
        int t = j + k;
        if (t >= eleTotal) {
          t -= eleTotal;
        }
        if (t == i) {
          break;
        }
        arr[j] = arr[t];
        j = t;
      }
      arr[j] = temp;
    }

    for (int i = 0; i < eleTotal; i++) {
      int rowIndex = i / n;
      shiftedGrid.get(rowIndex).add(arr[i]);
    }
    return shiftedGrid;
  }

  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
