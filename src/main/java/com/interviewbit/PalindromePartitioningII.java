package com.interviewbit;

public class PalindromePartitioningII {

  public static void main(String[] args) {
    String s = "nitik";
    int i = 0;
    int n = s.length();
    int j = n - 1;
    Integer[][] t = new Integer[n][n];
    System.out.println(minCutsRequired(s, i, j, t));
  }

  private static int minCutsRequired(String s, int i, int j, Integer[][] t) {
    if (i >= j || isPalindrome(s, i, j)) {
      return 0;
    }
    if (t[i][j] != null) {
      return t[i][j];
    }
    t[i][j] = Integer.MAX_VALUE;
    for (int k = i; k <= j - 1; k++) {
      int left, right;
      if (t[i][k] == null) {
        t[i][k] = minCutsRequired(s, i, k, t);
      }
      left = t[i][k];
      if (t[k + 1][j] == null) {
        t[k + 1][j] = minCutsRequired(s, k + 1, j, t);
      }
      right = t[k + 1][j];
      int temp = 1 + left + right;
      t[i][j] = Math.min(t[i][j], temp);
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