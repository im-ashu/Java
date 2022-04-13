package com.leetcode;

public class NumberLongestIncreasingSubsequence {

  public static void main(String[] args) {
    NumberLongestIncreasingSubsequence numberLongestIncreasingSubsequence = new NumberLongestIncreasingSubsequence();
    int[] nums = {1, 3, 5, 4, 7};
    System.out.println(numberLongestIncreasingSubsequence.findNumberOfLIS(nums));
  }

  public int findNumberOfLIS(int[] nums) {
    int n = nums.length;
    int[] t = new int[n];
    int oMax = 0;
    int[] count = new int[n];
    int res = 0;
    for (int i = 0; i < n; i++) {
      t[i] = count[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (t[i] == t[j] + 1) {
            count[i] += count[j];
          }
          if (t[i] < t[j] + 1) {
            t[i] = t[j] + 1;
            count[i] = count[j];
          }
        }
      }
      if (oMax == t[i]) {
        res += count[i];
      } else if (oMax < t[i]) {
        oMax = t[i];
        res = count[i];
      }
    }
    return res;
  }
}
