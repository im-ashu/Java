package com.datastructure.dynamicprogramming.lcs;

public class LongestRepeatingSubsequence {

  public static void main(String[] args) {
    String s = "AABEBCDD";
    int n = s.length();
    System.out.println(longestRepeatedSubSeq(s, n));
  }

  private static int longestRepeatedSubSeq(String s, int n) {
    int[][] t = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if ((s.charAt(i - 1) == s.charAt(j - 1)) && (i != j)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    StringBuilder res = new StringBuilder();

    // Traverse dp[][] from bottom right
    int i = n, j = n;
    while (i > 0 && j > 0) {
      if (t[i][j] == t[i - 1][j - 1] + 1) {
        res.append(s.charAt(i - 1));
        i--;
        j--;
      } else if (t[i][j] == t[i - 1][j]) {
        i--;
      } else {
        j--;
      }
    }
    System.out.println(res.reverse());
    return t[n][n];
  }
}