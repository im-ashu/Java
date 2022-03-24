package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
    List<Integer> A = new ArrayList<>(
        Arrays.asList(14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81,
            28, 78));
    System.out.println(l.lis(A));
  }

  public int lis(final List<Integer> A) {
    SortedSet<Integer> hs = new TreeSet<>(A);
    int n = A.size();
    int m = hs.size();
    Integer[] lis = hs.toArray(new Integer[m]);
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(t[i], -1);
    }
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        } else if (Objects.equals(A.get(i - 1), lis[j - 1])) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    return t[n][m];
  }
}