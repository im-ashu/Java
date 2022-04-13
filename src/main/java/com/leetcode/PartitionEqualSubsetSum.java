package com.leetcode;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

  public static void main(String[] args) {
    PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
    int[] nums = {1, 2, 3, 5};
    System.out.println(partitionEqualSubsetSum.canPartition(nums));
  }

  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = Arrays.stream(nums).sum();
    if ((sum & 1) == 1) {
      return false;
    }
    int partitionSum = (sum >> 1);
    boolean[][] t = new boolean[n + 1][partitionSum + 1];
    for (int i = 0; i < n + 1; i++) {
      t[i][0] = true;
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < partitionSum + 1; j++) {
        if (j >= nums[i - 1]) {
          t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][partitionSum];
  }
}
