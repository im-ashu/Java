package com.leetcode;

public class LongestPalindromeSubseq {

  public static void main(String[] args) {
    String s = "abba";
    System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq(s));
  }

  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    if (n == 1) {
      return 1;
    }
    String rev = new StringBuilder(s).reverse().toString();
    int[][] t = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s.charAt(i - 1) == rev.charAt(j - 1)) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    return t[n][n];
  }
}