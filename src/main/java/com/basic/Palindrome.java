package com.basic;

public class Palindrome {

  public static void main(String[] args) {
    String result = is_palindrome(1232);
    System.out.println(result);
  }

  public static String is_palindrome(int n) {
    int reverse = 0;
    int original = n;
    while (original != 0) {
      reverse = ((reverse * 10) + (original % 10));
      original = original / 10;
    }
    return (n == reverse) ? "Yes" : "No";
  }
}