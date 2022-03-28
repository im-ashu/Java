package com.leetcode;

public class ShortestPalindrome {

  public static void main(String[] args) {
    String s = "abad";
    System.out.println(new ShortestPalindrome().shortestPalindrome(s));
  }

  public String shortestPalindrome(String s) {
    String strDash = s + "#" + new StringBuilder(s).reverse();
    int lps = LPS(strDash);
    String ans = new StringBuilder(s.substring(lps)).reverse() + s;
    return ans;
  }

  public int LPS(String str) {
    int[] lps = new int[str.length()];
    int len = 0;
    int i = 1;
    while (i < str.length()) {
      if (str.charAt(i) == str.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len > 0) {
          len = lps[len - 1];

        } else {
          i++;
        }
      }
    }
    return lps[lps.length - 1];
  }
}