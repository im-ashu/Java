package com.interviewbit;

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
    for (int i = 0; i < n; ++i) {
      t[i][i] = true;
    }
    int start = 0;
    for (int i = 0; i < n - 1; i++) {
      if (A.charAt(i) == A.charAt(i + 1)) {
        t[i][i + 1] = true;
        start = i;
        maxLength = 2;
      }
    }
    for (int k = 3; k <= n; k++) {
      for (int i = 0, j = k - 1; j < n; i++, j++) {
        if (t[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
          t[i][j] = t[i + 1][j - 1];
          if (k > maxLength) {
            start = i;
            maxLength = k;
          }
        }

      }
    }
    return A.substring(start, start + maxLength);
  }
}