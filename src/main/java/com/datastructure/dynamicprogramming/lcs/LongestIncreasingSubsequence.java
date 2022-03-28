package com.datastructure.dynamicprogramming.lcs;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] nums = {14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28,
        78};
    System.out.println(longestIncreasingSubsequence(nums));
  }

  private static int longestIncreasingSubsequence(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
    int maxi = 0;
    for (int i = 0; i < n; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          if (lis[j] > max) {
            max = lis[j];
          }
        }
      }
      lis[i] = max + 1;
      if (lis[i] > maxi) {
        maxi = lis[i];
      }
    }
    return maxi;
  }
}
