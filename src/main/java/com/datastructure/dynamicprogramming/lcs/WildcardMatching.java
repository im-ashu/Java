package com.datastructure.dynamicprogramming.lcs;

public class WildcardMatching {

  public static void main(String[] args) {
    String pattern = "ab*";
    String text = "ab";

    System.out.println(wildcardMatching(pattern, text));
    System.out.println(wildcardMatchingMemoization(pattern, text));
    System.out.println(wildcardMatchingTabulation(pattern, text));
    System.out.println(wildcardMatchingTabulationSpaceOptimization(pattern, text));
  }

  private static boolean wildcardMatchingTabulationSpaceOptimization(String pattern, String text) {
    int n = pattern.length();
    int m = text.length();
    boolean[] prev = new boolean[m + 1];
    for (int i = 0; i < n + 1; i++) {
      boolean[] current = new boolean[m + 1];
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 && j == 0) {
          current[j] = true;
        } else if (i == 0) {
          current[j] = false;
        } else if (j == 0) {
          current[j] = prev[j];
        } else {
          if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
            current[j] = prev[j - 1];
          } else if (pattern.charAt(i - 1) == '*') {
            current[j] = prev[j] || current[j - 1];
          }
        }
      }
      prev = current;
    }
    return prev[m];
  }

  private static boolean wildcardMatchingTabulation(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    boolean[][] t = new boolean[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 && j == 0) {
          t[i][j] = true;
        } else if (i == 0) {
          t[i][j] = false;
        } else if (j == 0) {
          t[i][j] = t[i - 1][j];
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
          t[i][j] = t[i - 1][j - 1];
        } else if (s1.charAt(i - 1) == '*') {
          t[i][j] = t[i - 1][j] || t[i][j - 1];
        }
      }
    }
    return t[n][m];
  }

  private static boolean wildcardMatchingMemoization(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    Boolean[][] t = new Boolean[n + 1][m + 1];

    return wildcardMatchingMemoizationUtil(s1, s2, n, m, t);
  }

  private static boolean wildcardMatchingMemoizationUtil(String s1, String s2, int i, int j,
      Boolean[][] t) {
    if (i == 0 && j == 0) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    if (j == 0) {
      for (int k = 1; k < i + 1; k++) {
        if (s1.charAt(k - 1) != '*') {
          return false;
        }
      }
      return true;
    }
    if (t[i][j] != null) {
      return t[i][j];
    }
    if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
      return t[i][j] = wildcardMatchingMemoizationUtil(s1, s2, i - 1, j - 1, t);
    } else if (s1.charAt(i - 1) == '*') {
      return t[i][j] = (wildcardMatchingMemoizationUtil(s1, s2, i - 1, j, t)
          || wildcardMatchingMemoizationUtil(s1, s2, i, j - 1, t));
    }
    return t[i][j] = false;
  }

  private static boolean wildcardMatching(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    return wildcardMatchingUtil(s1, s2, n, m);
  }

  private static boolean wildcardMatchingUtil(String s1, String s2, int i, int j) {
    if (i == 0 && j == 0) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    if (j == 0) {
      for (int k = 1; k <= i; k++) {
        if (s1.charAt(k - 1) != '*') {
          return false;
        }
      }
      return true;
    }
    if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
      return wildcardMatchingUtil(s1, s2, i - 1, j - 1);
    } else if (s1.charAt(i - 1) == '*') {
      return wildcardMatchingUtil(s1, s2, i - 1, j) || wildcardMatchingUtil(s1, s2, i, j - 1);
    }
    return false;
  }
}
