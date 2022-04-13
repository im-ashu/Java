package com.leetcode;

public class InterleavingString {

  public static void main(String[] args) {
    InterleavingString interleavingString = new InterleavingString();
    String s1 = "aabcc", s2 = "dbbca", s3 = "dbbca";
    System.out.println(interleavingString.isInterleave(s1, s2, s3));
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    int x = s3.length();
    int[][][] t = new int[m][n][x];
    return isInterleaveUtil(s1, s2, s3, m, n, x, t);
  }

  private boolean isInterleaveUtil(String s1, String s2, String s3, int i, int j, int k,
      int[][][] t) {
    if (i == 0 && j == 0 && k == 0) {
      return true;
    }
    if (j == 0) {
      if (i != 0 && k != 0) {
        return s1.substring(0, i).equals(s3.substring(0, k));
      } else {
        return false;
      }
    }
    if (i == 0) {
      if (k != 0) {
        return s2.substring(0, j).equals(s3.substring(0, k));
      } else {
        t[i][j][k] = 0;
        return false;
      }
    }
    for (int i1 : new int[]{j, i, k}) {
      if (i1 == 0) {
        t[i][j][k] = 0;
        return false;
      }
    }

    if (s1.charAt(i - 1) == s3.charAt(k - 1)) {
      return (t[i][j][k] = isInterleaveUtil(s1, s2, s3, i - 1, j, k - 1, t) ? 1 : 0) == 1;
    } else if (s2.charAt(j - 1) == s3.charAt(k - 1)) {
      return (t[i][j][k] = isInterleaveUtil(s1, s2, s3, i, j - 1, k - 1, t) ? 1 : 0) == 1;
    }
    t[i][j][k] = 0;
    return false;
  }

}
