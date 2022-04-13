package com.leetcode;

public class PowXN {

  public static void main(String[] args) {
    PowXN powXN = new PowXN();
    double x = 100;
    int n = Integer.MIN_VALUE;
    System.out.println(powXN.myPow(x, n));
  }

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    int sign = n < 0 ? -1 : 1;
    double ans = 1;
    long longN = n;
    longN *= sign;
    while (longN > 0) {
      if ((longN & 1) == 0) { // n is even
        x = x * x;
        longN >>= 1;
      } else {
        ans = ans * x;
        longN -= 1;
      }
    }
    return sign > 0 ? ans : (1 / ans);
  }
}
