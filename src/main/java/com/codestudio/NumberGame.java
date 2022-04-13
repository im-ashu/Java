package com.codestudio;

public class NumberGame {

  public static void main(String[] args) {
    int n = 5;
    int x = 3;
    System.out.println(minimumCoins(n, x));
  }

  public static int minimumCoins(int n, int x) {
    // Write your code here.
    return minimumCoinsUtil(1, n, x);

  }

  private static int minimumCoinsUtil(int start, int n, int x) {
    if (start == n) {
      return 0;
    }
    if (start > n) {
      return Integer.MAX_VALUE;
    }
    int change = minimumCoinsUtil(start * x, n, x);
    int shuffle = Integer.MAX_VALUE;
    if (start > 9 && start % 10 != 0) {
      shuffle = minimumCoinsUtil(shuffle(start), n, x);
    }
    int min = Math.min(change, shuffle);
    if (min == Integer.MAX_VALUE || min < 0) {
      return -1;
    }
    return 1 + min;
  }

  private static int shuffle(int start) {
    String s = String.valueOf(start);
    int n = s.length();
    return Integer.parseInt(s.substring(1, n) + s.charAt(0));
  }

}
