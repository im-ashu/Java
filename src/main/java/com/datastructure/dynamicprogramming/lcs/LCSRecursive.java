package com.datastructure.dynamicprogramming.lcs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LCSRecursive {

  public static void main(String[] args) {
    String a = "qetui";
    String b = "qwertyu";
    int n = a.length();
    int m = b.length();
    int[][] t = new int[n + 1][m + 1];
    IntStream.range(0, n + 1).forEach(row -> Arrays.fill(t[row], -1));
    int lcs = lcs(a, b, n, m, t);
    System.out.println(lcs);
  }

  private static int lcs(String a, String b, int n, int m, int[][] t) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (t[n][m] != -1) {
      return t[n][m];
    }
    if (a.charAt(n - 1) == b.charAt(m - 1)) {
      return t[n][m] = (1 + lcs(a, b, n - 1, m - 1, t));
    } else {
      return t[n][m] = (Math.max(lcs(a, b, n - 1, m, t),
          lcs(a, b, n, m - 1, t)));
    }
  }
}