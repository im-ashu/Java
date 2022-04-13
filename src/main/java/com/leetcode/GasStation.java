package com.leetcode;

public class GasStation {

  public static void main(String[] args) {
    GasStation gasStation = new GasStation();
    int[] gas = {2, 3, 4};
    int[] cost = {3, 4, 3};
    System.out.println(gasStation.canCompleteCircuit(gas, cost));
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalRemain = 0;
    int remain = 0;
    int start = 0;
    int n = cost.length;
    for (int i = 0; i < n; i++) {
      totalRemain += gas[i] - cost[i];
      if (remain + gas[i] < cost[i]) {
        start = i + 1;
        remain = 0;
      } else {
        remain += gas[i] - cost[i];
      }
    }
    if (totalRemain < 0) {
      return -1;
    }
    return start;
  }
}
