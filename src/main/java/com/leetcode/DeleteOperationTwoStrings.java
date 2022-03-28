package com.leetcode;

import java.util.Arrays;

public class DeleteOperationTwoStrings {

  public static void main(String[] args) {
    String word1 = "sea";
    String word2 = "eat";
    System.out.println(new DeleteOperationTwoStrings().minDistance(word1, word2));
    System.out.println(new DeleteOperationTwoStrings().minDistanceMemoization(word1, word2));
  }

  private int minDistanceMemoization(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(t[i], -1);
    }
    return minDistanceMemoizationUtil(word1, word2, n, m, t);
  }

  private int minDistanceMemoizationUtil(String word1, String word2, int i, int j, int[][] t) {
    if (i == 0 && j == 0) {
      return 0;
    }
    if (i == 0) {
      return j;
    }
    if (j == 0) {
      return i;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
      int deleteWord1 = minDistanceMemoizationUtil(word1, word2, i - 1, j, t);
      int deleteWord2 = minDistanceMemoizationUtil(word1, word2, i, j - 1, t);
      return t[i][j] = 1 + Math.min(deleteWord1, deleteWord2);
    } else {
      return t[i][j] = minDistanceMemoizationUtil(word1, word2, i - 1, j - 1, t);
    }
  }

  public int minDistance(String word1, String word2) {
    return minDistance(word1, word2, word1.length(), word2.length());
  }

  private int minDistance(String word1, String word2, int i, int j) {
    if (i == 0 && j == 0) {
      return 0;
    }
    if (i == 0) {
      return j;
    }
    if (j == 0) {
      return i;
    }
    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
      int deleteWord1 = minDistance(word1, word2, i - 1, j);
      int deleteWord2 = minDistance(word1, word2, i, j - 1);
      return 1 + Math.min(deleteWord1, deleteWord2);
    } else {
      return minDistance(word1, word2, i - 1, j - 1);
    }
  }
}
