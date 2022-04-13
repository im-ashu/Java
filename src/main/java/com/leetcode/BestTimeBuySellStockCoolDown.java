package com.leetcode;

import java.util.Arrays;

public class BestTimeBuySellStockCoolDown {

  public static void main(String[] args) {
    BestTimeBuySellStockCoolDown bestTimeBuySellStockCoolDown = new BestTimeBuySellStockCoolDown();
    int[] prices = {1, 2, 3, 0, 2};
    System.out.println(bestTimeBuySellStockCoolDown.maxProfit(prices));
  }

  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] t = new int[n][2];
    for (int i = 0; i < n; i++) {
      Arrays.fill(t[i], -1);
    }
    return maxProfitUtil(prices, 0, 1, t);
  }

  private int maxProfitUtil(int[] prices, int index, int buy, int[][] t) {
    if (prices.length <= index) {
      return 0;
    }
    if (t[index][buy] != -1) {
      return t[index][buy];
    }
    int profit;
    if (buy == 1) {
      profit = Math.max(-prices[index] + maxProfitUtil(prices, index + 1, 0, t),
          maxProfitUtil(prices, index + 1, 1, t));
    } else {
      profit = Math.max(prices[index] + maxProfitUtil(prices, index + 2, 1, t),
          maxProfitUtil(prices, index + 1, 0, t));
    }
    return t[index][buy] = profit;
  }
}
