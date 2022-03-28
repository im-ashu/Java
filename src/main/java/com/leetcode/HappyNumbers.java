package com.leetcode;

public class HappyNumbers {

  public static void main(String[] args) {
    int n = 20;
    System.out.println(new HappyNumbers().isHappy(n));
  }

  public boolean isHappy(int n) {
    if (n < 10) {
      return (n == 1) || (n == 7);
    }
    int sum;
    do {
      sum = getSum(n);
      n = sum;
    }
    while (n > 9);
    return n == 1 || n == 7;
  }

  private int getSum(int n) {
    int sum = 0;
    while (n != 0) {
      int rem = n % 10;
      sum += (rem * rem);
      n /= 10;
    }
    return sum;
  }
}