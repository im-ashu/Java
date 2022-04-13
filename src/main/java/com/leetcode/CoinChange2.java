package com.leetcode;

import java.util.Arrays;

public class CoinChange2 {

  public static void main(String[] args) {
    CoinChange2 coinChange2 = new CoinChange2();
    int[] coins = {1, 2, 5};
    int amount = 5;
    System.out.println(coinChange2.change(amount, coins));
    System.out.println(coinChange2.changeTab(amount, coins));
  }

  public int change(int amount, int[] coins) {
    Arrays.sort(coins);
    int n = coins.length;
    int[][] t = new int[n + 1][amount + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(t[i], -1);
    }
    return changeUtil(amount, coins, coins.length, t);
  }

  private int changeUtil(int amount, int[] coins, int i, int[][] t) {
    if (amount == 0) {
      return 1;
    }
    if (i == 0) {
      return 0;
    }
    if (t[i][amount] != -1) {
      return t[i][amount];
    }

    int pick = 0;
    if (amount >= coins[i - 1]) {
      pick = changeUtil(amount - coins[i - 1], coins, i, t);
    }
    int notPick = changeUtil(amount, coins, i - 1, t);
    return t[i][amount] = pick + notPick;
  }

  private int changeTab(int amount, int[] coins) {
    Arrays.sort(coins);
    int n = coins.length;
    int[][] t = new int[n + 1][amount + 1];
    for (int i = 0; i < n + 1; i++) {
      t[i][0] = 1;
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < amount + 1; j++) {
        if (j >= coins[i - 1]) {
          t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][amount];
  }
}
