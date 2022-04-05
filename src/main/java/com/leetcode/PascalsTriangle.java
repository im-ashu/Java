package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

  public static void main(String[] args) {
    PascalsTriangle triangle = new PascalsTriangle();
    int n = 7;
    List<List<Integer>> rows = triangle.generate(n);
    for (List<Integer> row : rows) {
      for (Integer cols : row) {
        System.out.print(cols + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    List<Integer> prev = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> current = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          current.add(1);
        } else {
          current.add(prev.get(j) + prev.get(j - 1));
        }
      }
      prev = current;
      triangle.add(current);
    }
    return triangle;
  }
}
