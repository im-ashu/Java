package com.datastructure.dynamicprogramming.mcm;

import java.util.Arrays;

public class EvaluateExpressionToTrueBooleanParenthesization {

  private static int countWays(int N, String S) {
    int[][][] t = new int[N + 1][N + 1][2];

    for (int[][] row : t) {
      for (int[] col : row) {
        Arrays.fill(col, -1);
      }
    }
    return parenthesis_count(S, 0, N - 1, 1, t);
  }

  private static int parenthesis_count(String s, int i, int j, int isTrue, int[][][] t) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      if (isTrue == 1) {
        return s.charAt(i) == 'T' ? 1 : 0;
      } else {
        return s.charAt(i) == 'F' ? 1 : 0;
      }
    }
    if (t[i][j][isTrue] != -1) {
      return t[i][j][isTrue];
    }
    int tempAns = 0;
    int leftTrue, rightTrue, leftFalse, rightFalse;
    for (int k = i + 1; k <= j - 1; k = k + 2) {
      if (t[i][k - 1][1] != -1) {
        leftTrue = t[i][k - 1][1];
      } else {
        leftTrue = parenthesis_count(s, i, k - 1, 1, t);
        t[i][k - 1][1] = leftTrue;
      }
      if (t[i][k - 1][0] != -1) {
        leftFalse = t[i][k - 1][0];
      } else {
        leftFalse = parenthesis_count(s, i, k - 1, 0, t);
        t[i][k - 1][0] = leftFalse;
      }
      if (t[k + 1][j][1] != -1) {
        rightTrue = t[k + 1][j][1];
      } else {
        rightTrue = parenthesis_count(s, k + 1, j, 1, t);
        t[k + 1][j][1] = rightTrue;
      }
      if (t[k + 1][j][0] != -1) {
        rightFalse = t[k + 1][j][0];
      } else {
        rightFalse = parenthesis_count(s, k + 1, j, 0, t);
        t[k + 1][j][0] = rightFalse;
      }
      if (s.charAt(k) == '&') {
        if (isTrue == 1) {
          tempAns += (leftTrue * rightTrue);
        } else {
          tempAns += (leftTrue * rightFalse) + (leftFalse * rightFalse) + (leftFalse * rightTrue);
        }
      } else if (s.charAt(k) == '|') {
        if (isTrue == 1) {
          tempAns += (leftTrue * rightFalse) + (leftTrue * rightTrue) + (leftFalse * rightTrue);
        } else {
          tempAns += (leftFalse * rightFalse);
        }
      } else if (s.charAt(k) == '^') {
        if (isTrue == 1) {
          tempAns += (leftTrue * rightFalse) + (leftFalse * rightTrue);
        } else {
          tempAns += (leftFalse * rightFalse) + (leftTrue * rightTrue);
        }
      }
      t[i][j][isTrue] = tempAns;
    }
    return tempAns;
  }

  public static void main(String[] args) {
    String symbols = "TTFT";
    String operators = "|&^";
    StringBuilder S = new StringBuilder();
    int j = 0;

    for (int i = 0; i < symbols.length(); i++) {
      S.append(symbols.charAt(i));
      if (j < operators.length()) {
        S.append(operators.charAt(j++));
      }
    }

    int N = S.length();
    System.out.println(countWays(N, S.toString()));
  }
}