package com.interviewbit;

public class BuySellStocksKTransactions {

  public static void main(String[] args) {
    int[] price = {11, 6, 7, 19, 4, 1, 6, 18, 4};
    int k = 2;
    System.out.println(maxProfit(price, k));
  }

  private static int maxProfit(int[] price, int k) {
    int n = price.length;
    int[][] dp = new int[k + 1][n];
    for (int t = 1; t <= k; t++) {
      int max = Integer.MIN_VALUE;
      for (int d = 1; d < n; d++) {
        max = Math.max(max, dp[t - 1][d - 1] - price[d - 1]);
        dp[t][d] = Math.max(max + price[d], dp[t][d - 1]);
      }
    }
    return dp[k][n - 1];
  }
}