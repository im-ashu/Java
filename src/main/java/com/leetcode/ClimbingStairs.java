package com.leetcode;

import java.util.Arrays;

public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    int n = 4;
    System.out.println(climbingStairs.climbStairs(n));
    System.out.println(climbingStairs.climbStairsMemoization(n));
    System.out.println(climbingStairs.climbStairsTabulation(n));
    System.out.println(climbingStairs.climbStairsSpaceOptimization(n));
  }

  private int climbStairsSpaceOptimization(int n) {
    int first = 1;
    int second = 1;
    for (int i = 2; i <= n; i++) {
      int current = second + first;
      first = second;
      second = current;
    }
    return second;
  }

  private int climbStairsTabulation(int n) {
    int[] t = new int[n + 1];
    t[0] = 1;
    t[1] = 1;
    for (int i = 2; i <= n; i++) {
      t[i] = t[i - 1] + t[i - 2];
    }
    return t[n];
  }

  private int climbStairsMemoization(int n) {
    int[] t = new int[n + 1];
    Arrays.fill(t, -1);
    return climbStairsMemoization(n, t);
  }

  private int climbStairsMemoization(int n, int[] t) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (t[n] != -1) {
      return t[n];
    }
    int twoSteps = climbStairs(n - 2);
    int oneStep = climbStairs(n - 1);
    return t[n] = oneStep + twoSteps;
  }

  public int climbStairs(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    int twoSteps = climbStairs(n - 2);
    int oneStep = climbStairs(n - 1);
    return oneStep + twoSteps;
  }
}
