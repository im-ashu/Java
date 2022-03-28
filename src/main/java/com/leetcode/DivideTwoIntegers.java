package com.leetcode;

public class DivideTwoIntegers {

  public static void main(String[] args) {
    int dividend = 7, divisor = -3;
    System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
  }

  public int divide(int dividend, int divisor) {
    int sign = 1;
    if (dividend > 0 ^ divisor > 0) {
      sign = -1;
    }

    long dvd = Math.abs((long) dividend);
    long dvs = Math.abs((long) divisor);

   if ((dvd == 0) || (dvd < dvs)) {
    return 0;
   }
    long lans = longDivide(dvd, dvs);
    int ans;
    if (lans > Integer.MAX_VALUE) {
      ans = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    } else {
      ans = (int) (sign * lans);
    }
    return ans;
  }

  public long longDivide(long dividend, long divisor) {
    if (dividend < divisor) {
      return 0;
    }
    long multiplier = 1;
    long sum = divisor;
    while ((sum << 1) <= dividend) {
      sum <<= 1;
      multiplier <<= 1;
    }
    return multiplier + longDivide(dividend - sum, divisor);
  }
}