package com.leetcode;

public class StringToInteger {

  public static void main(String[] args) {
    StringToInteger s = new StringToInteger();
    String str = "2147483646";
    System.out.println(s.myAtoi(str));
  }

  public int myAtoi(String s) {
    s = s.trim();
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    int sign = 1;
    int start;
    start = 0;
    if (s.charAt(0) == '-') {
      sign = -1;
      start = 1;
    } else if (s.charAt(0) == '+') {
      sign = 1;
      start = 1;
    }
    int i = start;
    if (start == n) {
      return 0;
    }
    if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
      return 0;
    }
    long res = 0;
    while (i < n && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
      res = (res * 10) + (s.charAt(i) - '0');
      if (res * sign > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (res * sign < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      i++;
    }
    return (int) res * sign;
  }
}