package com.hackerrank.dynamicprogramming;

public class Abbreviation {

  public static void main(String[] args) {
    String a = "AbcDE";
    String b = "AFDE";
    String result = abbreviation(a, b);
    System.out.println(result);
  }

  public static String abbreviation(String a, String b) {
    // Write your code here
    int n = a.length();
    int m = b.length();
    Boolean[][] t = new Boolean[n + 1][m + 1];
    return abbreviationUtil(a, b, n, m, t) ? "YES" : "NO";
  }

  private static boolean abbreviationUtil(String a, String b, int i, int j, Boolean[][] t) {
    if (i == 0 && j == 0) {
      return true;
    }
    if (j == 0) {
      while (i > 0) {
        if (Character.isUpperCase(a.charAt(i - 1))) {
          return false;
        }
        i--;
      }
      return true;
    }
    if (i == 0) {
      return false;
    }
    if (t[i][j] != null) {
      return t[i][j];
    }
    if (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) {
      return t[i][j] = abbreviationUtil(a, b, i - 1, j - 1, t);
    }
    if (Character.isLowerCase(a.charAt(i - 1))) {
      return t[i][j] = abbreviationUtil(a, b, i - 1, j, t);
    }
    return t[i][j] = false;
  }

  public static String abbreviationTab(String a, String b) {
    int n = a.length();
    int m = b.length();
    boolean[][] t = new boolean[n + 1][m + 1];
    t[0][0] = true;
    for (int i = 1; i < n + 1; i++) {
      t[i][0] = t[i - 1][0] && Character.isLowerCase(a.charAt(i - 1));
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1];
        } else if (Character.isLowerCase(a.charAt(i - 1))) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = false;
        }
      }
    }
    return t[n][m] ? "YES" : "NO";
  }

}
