package com.datastructure.dynamicprogramming.lcs;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String s = "babad";
    LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
    System.out.println(lps.longestPalindrome(s));
  }

  public String longestPalindrome(String A) {
    int n = A.length();
    if (n == 0) {
      return "";
    }
    boolean[][] t = new boolean[n][n];
    int maxLength = 1;
    int start = 0;

    for (int g = 0; g < A.length(); g++) {
      for (int i = 0, j = g; j < t.length; i++, j++) {
        if (g == 0) {
          t[i][j] = true;
        } else {
          final boolean b = A.charAt(i) == A.charAt(j);
          if (g == 1) {
            if (b) {
              t[i][j] = true;
              maxLength = g + 1;
              start = i;
            }
          } else {
            if (b && t[i + 1][j - 1]) {
              t[i][j] = true;
              if (g + 1 > maxLength) {
                start = i;
                maxLength = g + 1;
              }
            }
          }
        }
      }
    }

    return A.substring(start, start + maxLength);
  }
}