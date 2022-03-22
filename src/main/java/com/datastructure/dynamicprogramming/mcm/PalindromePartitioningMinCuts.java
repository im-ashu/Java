package com.datastructure.dynamicprogramming.mcm;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PalindromePartitioningMinCuts {

  public static void main(String[] args) {
    String s = "scaac";
    int n = s.length();
    int i = 0;
    int j = n - 1;
    int[][] t = new int[n][n];
    IntStream.range(0, n).forEach(row -> Arrays.fill(t[row], -1));
    System.out.println(minimumCutsRequired(s, i, j, t));
  }

  private static int minimumCutsRequired(String s, int i, int j, int[][] t) {
    if (i >= j || isPalindrome(s, i, j)) {
      return 0;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    t[i][j] = Integer.MAX_VALUE;
    for (int k = i; k <= j - 1; k++) {
      if (t[i][k] == -1) {
        t[i][k] = minimumCutsRequired(s, i, k, t);
      }
      if (t[k + 1][j] == -1) {
        t[k + 1][j] = minimumCutsRequired(s, k + 1, j, t);
      }
      t[i][j] = Math.min(t[i][j], (t[i][k] + t[k + 1][j] + 1));
      if (t[i][j] == 1) {
        return 1;
      }
    }
    return t[i][j];
  }

  private static boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}