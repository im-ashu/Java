package com.datastructure.dynamicprogramming.lcs;

public class LongestPalindromicSubsequence {

  public static void main(String[] args) {
    String a = "agbcba";
    System.out.println(
        "Longest Palindromic Subsequence Length : " + longestPalindromicSubsequence(a, a.length()));
  }

  private static int longestPalindromicSubsequence(String a, int n) {
    String b = new StringBuilder(a).reverse().toString();
    int[][] t = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    StringBuilder lps = new StringBuilder();
    int i = n;
    int j = n;
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        lps.append(a.charAt(i - 1));
        i--;
        j--;
      } else if (t[i - 1][j] > t[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    System.out.println(lps);
    return t[n][n];
  }
}