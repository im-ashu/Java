package com.leetcode;

import java.util.Arrays;

public class CoinChange {

  public static void main(String[] args) {
    CoinChange coinChange = new CoinChange();
    int[] coin = {1, 2, 5};
    int amount = 100;
    System.out.println(coinChange.coinChange(coin, amount));
  }

  public int coinChange(int[] coins, int amount) {
    int[] t = new int[amount + 1];
    Arrays.fill(t, -1);
    int result = coinChangeUtil(coins, amount, t);
    if (result == Integer.MAX_VALUE) {
      return -1;
    }
    return result;
  }

  private int coinChangeUtil(int[] coins, int amount, int[] t) {
    if (amount == 0) {
      return 0;
    }
    t[amount] = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (coin <= amount) {
        int temp;
        if (t[amount - coin] != -1) {
          temp = t[amount - coin];
        } else {
          temp = coinChangeUtil(coins, amount - coin, t);
          t[amount - coin] = temp;
        }
        if (temp != Integer.MAX_VALUE) {
          t[amount] = Math.min(t[amount], 1 + temp);
        }
      }
    }
    return t[amount];
  }

}
