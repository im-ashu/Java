package com.leetcode;

public class MinCostClimbingStairs {

  public static void main(String[] args) {
    MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
    int[] cost = {10, 15, 20};
    System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
  }

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int first = cost[0];
    int second = cost[1];
    int current;
    for (int i = 2; i < n; i++) {
      current = cost[i] + Math.min(first, second);
      first = second;
      second = current;
    }
    return Math.min(first, second);
  }

}
