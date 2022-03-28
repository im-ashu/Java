package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

  public static void main(String[] args) {
    int n = 20;
    System.out.println(new CountPrimes().countPrimes(n));
  }

  public int countPrimes(int n) {
    int count = 0;
    boolean[] notPrimes = new boolean[n + 1];
    List<Integer> res = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (!notPrimes[i]) {
        count++;
        res.add(i);
        for (int j = 2 * i; j <= n; j = j + i) {
          notPrimes[j] = true;
        }
      }
    }
    for (Integer primes : res) {
      System.out.print(primes + " ");
    }
    System.out.println();
    return count;
  }
}