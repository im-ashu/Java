package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class BuySellStocksInfiniteTransactions {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2));
    System.out.println(maxProfit(A));
  }

  private static int maxProfit(ArrayList<Integer> A) {
    int n = A.size();
    if (n == 0 || n == 1) {
      return 0;
    }
    int profit = 0;
    for (int i = 1; i < n; i++) {
      if (A.get(i) > A.get(i - 1)) {
        profit += A.get(i) - A.get(i - 1);
      }
    }

    return profit;
  }
}