package com.datastructure.dynamicprogramming.lcs;

public class LCSubStr {

  public static void main(String[] args) {
    String X = "abcdxyz";
    String Y = "xyzabcd";

    int n = X.length();
    int m = Y.length();

    System.out.println(longestCommonSubstring(X, Y, n, m));
  }

  private static int longestCommonSubstring(String str1, String str2, int n, int m) {
    int[][] t = new int[n + 1][m + 1];
    int result = Integer.MIN_VALUE;
    int a = 0, b = 0;
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          t[i][j] = 1 + t[(i - 1)][j - 1];
          if (result < t[i][j]) {
            result = t[i][j];
            a = i;
            b = j;
          }
        } else {
          t[i][j] = 0;
        }
      }
    }
    int i = a;
    int j = b;
    char[] lcsub = new char[result];
    int index = result;
    while (i > 0 && j > 0 && t[i][j] != 0) {
      lcsub[--index] = str1.charAt(i - 1);
      i--;
      j--;
    }
    System.out.println(new String(lcsub));
    return result;
  }
}