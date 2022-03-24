package com.interviewbit;

public class BuySellStocksTwoTransactions {

  public static void main(String[] args) {
    int[] price = {11, 6, 7, 19, 4, 1, 6, 18, 4};
    System.out.println(maxProfit(price));
  }

  private static int maxProfit(int[] price) {
    int maxProfit = Integer.MIN_VALUE;
    int n = price.length;
    int[] dpSellRight = new int[n];
    int mnr = price[0];
    for (int i = 1; i < n; i++) {
      mnr = Math.min(mnr, price[i]);
      dpSellRight[i] = Math.max(price[i] - mnr, dpSellRight[i - 1]);
    }

    int mxl = price[n - 1];
    int[] dpBuyLeft = new int[n];
    for (int i = n - 2; i >= 0; i--) {
      mxl = Math.max(mxl, price[i]);
      dpBuyLeft[i] = Math.max(mxl - price[i], dpBuyLeft[i + 1]);
    }

    for (int i = 0; i < n; i++) {
      maxProfit = Math.max(maxProfit, dpSellRight[i]
          + dpBuyLeft[i]);
    }
    return maxProfit;
  }
}