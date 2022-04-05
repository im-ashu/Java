package com.datastructure.dynamicprogramming.unboundedknapsack;

import java.util.Arrays;

public class MinimumNoOfCoins {

  public static void main(String[] args) {
    int[] coin = {1, 5, 7};
    int sum = 18;
    int result = minCoin(coin, sum);
    System.out.println(result);
    int[] t = new int[sum + 1];
    Arrays.fill(t, -1);
    result = minCoinMemoization(coin, sum, t);
    System.out.println(result);
  }

  private static int minCoin(int[] coin, int sum) {
    if (sum == 0) {
      return 0;
    }
    int mini = Integer.MAX_VALUE;
    for (int j = 0, n = coin.length; j < n; j++) {
      if (coin[j] <= sum) {
        int temp = minCoin(coin, sum - coin[j]);
        mini = Math.min(mini, 1 + temp);
      }
    }
    return mini;
  }

  private static int minCoinMemoization(int[] coin, int sum, int[] t) {
    if (sum == 0) {
      return 0;
    }
    if (t[sum] != -1) {
      return t[sum];
    }
    t[sum] = Integer.MAX_VALUE;
    for (int i : coin) {
      if (i <= sum) {
        int temp = minCoinMemoization(coin, sum - i, t);
        if (temp != Integer.MAX_VALUE) {
          t[sum] = Math.min(t[sum], 1 + temp);
        }
      }
    }
    return t[sum];
  }

}
