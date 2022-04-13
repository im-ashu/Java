package com.leetcode;

public class PalindromicSubstrings {

  public static void main(String[] args) {
    PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
    String s = "abc";
    System.out.println(palindromicSubstrings.countSubstrings(s));
  }

  public int countSubstrings(String s) {
    int n = s.length();
    boolean[][] t = new boolean[n][n];
    int count = 0;
    for (int gap = 0; gap < n; gap++) {
      for (int i = 0, j = gap; j < n; i++, j++) {
        if (gap == 0) {
          t[i][i] = true;
          count++;
        } else if (gap == 1) {
          if (s.charAt(i) == s.charAt(j)) {
            t[i][j] = true;
            count++;
          }
        } else {
          if (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1]) {
            t[i][j] = true;
            count++;
          }
        }
      }
    }
    return count;
  }
}
