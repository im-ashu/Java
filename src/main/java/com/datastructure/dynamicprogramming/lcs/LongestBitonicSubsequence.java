package com.datastructure.dynamicprogramming.lcs;

public class LongestBitonicSubsequence {

  public static void main(String[] args) {
    int[] nums = {14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28,
        78};
    System.out.println(longestBitonicSubsequence(nums));
  }

  private static int longestBitonicSubsequence(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
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
    }
    int[] lds = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      int max = 0;
      for (int j = n - 1; j > i; j--) {
        if (nums[j] < nums[i]) {
          if (lds[j] > max) {
            lds[j] = max;
          }
        }
      }
      lds[i] = max;
    }
    int maxi = 0;
    for (int i = 0; i < n; i++) {
      maxi = Math.max(maxi, lds[i] + lis[i] - 1);
    }
    return maxi;
  }
}
