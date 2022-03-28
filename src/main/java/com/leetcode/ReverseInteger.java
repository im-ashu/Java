package com.leetcode;

public class ReverseInteger {

  public static void main(String[] args) {
    ReverseInteger r = new ReverseInteger();
    int x = -123;
    System.out.println(r.reverse(x));
  }

  public int reverse(int x) {
    if (x == 0) {
      return 0;
    }
    int signMultiplier = 1;
    if (x < 0) {
      signMultiplier = -1;
      x = x * signMultiplier;
    }
    int rev = 0;
    while (x > 0) {
      if (rev * signMultiplier > Integer.MAX_VALUE / 10
          || rev * signMultiplier < Integer.MIN_VALUE / 10) {
        return 0;
      }

      rev = (rev * 10) + (x % 10);
      x /= 10;
    }
    return signMultiplier * rev;
  }
}