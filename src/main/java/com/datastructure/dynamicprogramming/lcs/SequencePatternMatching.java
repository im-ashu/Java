package com.datastructure.dynamicprogramming.lcs;

public class SequencePatternMatching {

  public static void main(String[] args) {
    String a = "ADXCPY";
    String b = "AXY";
    int n = a.length();
    int m = b.length();
    String lcs = lcs(a, b, n, m);
    System.out.println("Sequence Pattern " + (lcs.equals(b) ? "" : "not ") + "Present");
  }

  private static String lcs(String a, String b, int n, int m) {
    int[][] t = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    StringBuilder s = new StringBuilder();
    int i = n;
    int j = m;
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        s.append(a.charAt(i - 1));
        i--;
        j--;
      } else if (t[i - 1][j] > t[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    return s.reverse().toString();
  }
}