package com.leetcode;

public class MaximumWealth {

  public static void main(String[] args) {
    int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
    System.out.println(new MaximumWealth().maximumWealth(accounts));
  }

  public int maximumWealth(int[][] accounts) {
    int max = 0;
    int rows = accounts.length;
    int cols = accounts[0].length;
    for (int i = 0; i < rows; i++) {
      int wealth = 0;
      for (int j = 0; j < cols; j++) {
        wealth += accounts[i][j];
      }
      max = Math.max(max, wealth);
    }
    return max;
  }
}
