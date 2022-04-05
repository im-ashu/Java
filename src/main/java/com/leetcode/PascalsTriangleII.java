package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

  public static void main(String[] args) {
    PascalsTriangleII triangle = new PascalsTriangleII();
    int n = 5;
    List<Integer> row = triangle.getRow(n);
    for (Integer cols : row) {
      System.out.print(cols + " ");
    }
  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> prev = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> current = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          current.add(1);
        } else {
          current.add(prev.get(j) + prev.get(j - 1));
        }
      }
      prev = current;
    }
    return prev;
  }
}
