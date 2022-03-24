package com.datastructure.dynamicprogramming.lcs;

import java.util.Arrays;

public class EditDistance {

  public static void main(String[] args) {
    String s1 = "horse";
    String s2 = "ross";

    System.out.println(editDistance(s1, s2));
    System.out.println(editDistanceMemoization(s1, s2));
    System.out.println(editDistanceTabulation(s1, s2));
    System.out.println(editDistanceTabulationSpaceOptimization(s1, s2));
  }

  private static int editDistanceTabulationSpaceOptimization(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[] prev = new int[m + 1];
    for (int i = 0; i < n + 1; i++) {
      int[] current = new int[m + 1];
      for (int j = 0; j < m + 1; j++) {
        if (i == 0) {
          current[j] = j;
        } else if (j == 0) {
          current[j] = i;
        } else {
          if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            current[j] = prev[j - 1];
          } else {
            int replace = prev[j - 1];
            int delete = prev[j];
            int add = current[j - 1];
            current[j] = 1 + Math.min(replace, Math.min(delete, add));
          }
        }
      }
      prev = current;
    }
    return prev[m];
  }

  private static int editDistanceTabulation(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0) {
          t[i][j] = j;
        } else if (j == 0) {
          t[i][j] = i;
        } else {
          if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            t[i][j] = t[i - 1][j - 1];
          } else {
            int replace = t[i - 1][j - 1];
            int delete = t[i - 1][j];
            int add = t[i][j - 1];
            t[i][j] = 1 + Math.min(replace, Math.min(delete, add));
          }
        }
      }
    }
    return t[n][m];
  }

  private static int editDistanceMemoization(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(t[i], -1);
    }
    return editDistanceMemoizationUtil(s1, s2, n, m, t);
  }

  private static int editDistanceMemoizationUtil(String s1, String s2, int i, int j, int[][] t) {
    if (i == 0 && j == 0) {
      return 0;
    }
    if (i != 0 && j == 0) {
      return i; // delete all remaining characters
    }
    if (i == 0) {
      return j; // add all remaining characters
    }

    if (t[i][j] != -1) {
      return t[i][j];
    }

    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      return t[i][j] = editDistanceUtil(s1, s2, i - 1, j - 1);
    } else {
      int replace = editDistanceUtil(s1, s2, i - 1, j - 1);
      int delete = editDistanceUtil(s1, s2, i - 1, j);
      int add = editDistanceUtil(s1, s2, i, j - 1);
      return t[i][j] = 1 + Math.min(replace, Math.min(delete, add));
    }
  }

  private static int editDistance(String s1, String s2) {
    return editDistanceUtil(s1, s2, s1.length(), s2.length());
  }

  private static int editDistanceUtil(String s1, String s2, int i, int j) {
    if (i == 0 && j == 0) {
      return 0;
    }
    if (i != 0 && j == 0) {
      return i; // delete all remaining characters
    }
    if (i == 0) {
      return j; // add all remaining characters
    }

    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      return editDistanceUtil(s1, s2, i - 1, j - 1);
    } else {
      int replace = editDistanceUtil(s1, s2, i - 1, j - 1);
      int delete = editDistanceUtil(s1, s2, i - 1, j);
      int add = editDistanceUtil(s1, s2, i, j - 1);
      return 1 + Math.min(replace, Math.min(delete, add));
    }
  }
}
