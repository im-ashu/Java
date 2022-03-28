package com.leetcode;

public class PalindromeNumber {

  public static void main(String[] args) {
    PalindromeNumber pn = new PalindromeNumber();
    int x = 121;
    System.out.println(pn.isPalindrome(x));
  }

  public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int rev = 0;
    while (x > rev) {
      rev = rev * 10 + (x % 10);
      x /= 10;
    }
    return (x == rev || (x == (rev / 10)));
  }
}