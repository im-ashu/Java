package com.leetcode;

public class MaximumDifference {

  public static void main(String[] args) {
    int[] nums = {1, 5, 2, 10};
    System.out.println(new MaximumDifference().maximumDifference(nums));

  }

  public int maximumDifference(int[] nums) {
    int n = nums.length;
    if (n == 0 || n == 1) {
      return -1;
    }
    int mnl = nums[0];
    int maxDifference = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      mnl = Math.min(mnl, nums[i]);
      maxDifference = Math.max(maxDifference, nums[i] - mnl);
    }
    return maxDifference == 0 ? -1 : maxDifference;
  }
}