package com.datastructure.dynamicprogramming.lcs;

public class ShortestCommonSuperSequence {

  public static void main(String[] args) {
    String a = "AGGTAB";
    String b = "GXTXAYB";
    int n = a.length();
    int m = b.length();
    int lcs = lcs(a, b, n, m);
    int scss = a.length() + b.length() - lcs;
    System.out.println("Shortest Common Super Sequence length is : " + scss);
  }

  private static int lcs(String a, String b, int n, int m) {
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    int i = n;
    int j = m;
    StringBuilder scs = new StringBuilder();
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        scs.append(a.charAt(i - 1));
        i--;
        j--;
      } else if (t[i][j] == t[i - 1][j]) {
        scs.append(a.charAt(i - 1));
        i--;
      } else {
        scs.append(b.charAt(j - 1));
        j--;
      }
    }
    while (i > 0) {
      scs.append(a.charAt(i - 1));
      i--;
    }
    while (j > 0) {
      scs.append(b.charAt(j - 1));
      j--;
    }
    System.out.println(scs.reverse());
    return t[n][m];
  }
}