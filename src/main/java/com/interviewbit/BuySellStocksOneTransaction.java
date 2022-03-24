package com.interviewbit;

public class BuySellStocksOneTransaction {

  public static void main(String[] args) {
    int[] price = {11, 6, 7, 19, 4, 1, 6, 18, 4};
    System.out.println(maxProfit(price));
  }

  private static int maxProfit(int[] price) {
    int maxProfit = Integer.MIN_VALUE;
    int n = price.length;
    int[] mxl = new int[n];
    mxl[0] = 0;
    int[] maxProfitToday = new int[n];
    for (int i = 1; i < n; i++) {
      if (price[mxl[i - 1]] >= price[i]) {
        mxl[i] = i;
      } else {
        mxl[i] = mxl[i - 1];
      }
    }
    for (int i = 0; i < n; i++) {
      maxProfitToday[i] = price[i] - price[mxl[i]];
      maxProfit = Math.max(maxProfit, maxProfitToday[i]);
    }
    return maxProfit;
  }
}