package com.datastructure.dynamicprogramming.lcs;

public class LCS {

  public static void main(String[] args) {
    String a = "AGGTAB";
    String b = "GXTXAYB";
    int n = a.length();
    int m = b.length();
    int lcs = lcs(a, b, n, m);
    System.out.println("Length of longest common subsequence : " + lcs);
    System.out.println("Longest common subsequence : " + longestCommonSubsequence(a, b, n, m));
  }

  private static int lcs(String a, String b, int n, int m) {
    int[][] t = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    System.out.println(printLCS(a, b, n, m, t));
    return t[n][m];
  }

  private static String printLCS(String a, String b, int n, int m, int[][] t) {
    int index = t[n][m];
    char[] lcs = new char[index];
    int i = n;
    int j = m;
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        lcs[--index] = b.charAt(j - 1);
        i--;
        j--;
      } else if (t[i - 1][j] > t[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    return new String(lcs);
  }

  private static String longestCommonSubsequence(String str1, String str2, int n, int m) {
    String[][] t = new String[2][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i % 2][j] = "";
        } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          t[i % 2][j] = t[(i - 1) % 2][j - 1] + str1.charAt(i - 1);
        } else {
          if (t[(i - 1) % 2][j].length() > t[i % 2][j - 1].length()) {
            t[i % 2][j] = t[(i - 1) % 2][j];
          } else {
            t[i % 2][j] = t[i % 2][j - 1];
          }
        }
      }
    }
    return t[n % 2][m];
  }
}