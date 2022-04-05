package com.leetcode;

public class ValidPalindromeII {

  public static void main(String[] args) {
    ValidPalindromeII validPalindromeII = new ValidPalindromeII();
    String s = "abca";
    System.out.println(validPalindromeII.validPalindrome(s));
  }

  public boolean validPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i, j - 1);
      }
      i++;
      j--;
    }
    return true;
  }

  public boolean checkPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
