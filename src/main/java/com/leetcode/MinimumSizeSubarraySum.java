package com.leetcode;

public class MinimumSizeSubarraySum {

  public static void main(String[] args) {
    MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
    int target = 11;
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(minimumSizeSubarraySum.minSubArrayLen(target, nums));
  }

  public int minSubArrayLen(int target, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    int end = 0;
    int begin = 0;
    int n = nums.length;
    int sum = 0;
    while (end < n) {
      sum += nums[end];
      while (sum >= target) {
        minLength = Math.min(minLength, end - begin + 1);
        sum -= nums[begin];
        begin++;
      }
      end++;
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}
