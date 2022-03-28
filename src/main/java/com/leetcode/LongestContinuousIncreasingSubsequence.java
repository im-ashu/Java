package com.leetcode;

public class LongestContinuousIncreasingSubsequence {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 1};
    System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums));
  }

  public int findLengthOfLCIS(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return n;
    }
    int count = 1;
    int maxi = 1;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        count++;
        maxi = Math.max(count, maxi);
      } else {
        count = 1;
      }
    }
    return maxi;
  }
}