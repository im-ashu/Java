package com.datastructure.dynamicprogramming.lcs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DistinctSubsequences {

  public static void main(String[] args) {
    String s1 = "babgbag";
    String s2 = "bag";
    System.out.println(distinctSubsequences(s1, s2));
    System.out.println(distinctSubsequencesMemoization(s1, s2));
    System.out.println(distinctSubsequencesTabulation(s1, s2));
    System.out.println(distinctSubsequencesTabulationSpaceOptimization(s1, s2));
  }

  private static int distinctSubsequencesTabulationSpaceOptimization(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[] prev = new int[m + 1];
    prev[0] = 1;

    for (int i = 1; i < n + 1; i++) {
      for (int j = m; j > 0; j--) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          prev[j] = prev[j - 1] + prev[j];
        }
      }
    }
    return prev[m];
  }

  private static int distinctSubsequencesTabulation(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] t = new int[n + 1][m + 1];
    IntStream.range(0, m + 1).forEach(col -> t[0][col] = 0);
    IntStream.range(0, n + 1).forEach(row -> t[row][0] = 1);

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][m];
  }

  private static int distinctSubsequencesMemoization(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(t[i], -1);
    }
    return distinctSubsequencesMemoizationUtil(s1, s2, n, m, t);
  }

  private static int distinctSubsequencesMemoizationUtil(String s1, String s2, int i, int j,
      int[][] t) {
    if (j == 0) {
      return 1;
    }
    if (i == 0) {
      return 0;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      return t[i][j] =
          distinctSubsequencesUtil(s1, s2, i - 1, j - 1) + distinctSubsequencesUtil(s1, s2, i - 1,
              j);
    }
    return t[i][j] = distinctSubsequencesUtil(s1, s2, i - 1, j);
  }

  private static int distinctSubsequences(String s1, String s2) {
    return distinctSubsequencesUtil(s1, s2, s1.length(), s2.length());
  }

  private static int distinctSubsequencesUtil(String s1, String s2, int i, int j) {
    if (j == 0) {
      return 1;
    }
    if (i == 0) {
      return 0;
    }
    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      return distinctSubsequencesUtil(s1, s2, i - 1, j - 1) + distinctSubsequencesUtil(s1, s2,
          i - 1, j);
    }
    return distinctSubsequencesUtil(s1, s2, i - 1, j);
  }
}
