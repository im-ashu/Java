package com.leetcode;

import java.util.Arrays;

public class JumpGame {

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 1, 4};
    System.out.println(new JumpGame().canJump(nums));
  }

  public boolean canJump(int[] nums) {
    int n = nums.length;
    int[] t = new int[n];
    Arrays.fill(t, Integer.MAX_VALUE);
    t[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] == 0) {
        t[i] = Integer.MAX_VALUE;
      } else if (nums[i] + i >= n - 1) {
        t[i] = 1;
      } else {
        int max = Integer.MAX_VALUE;
        int steps = nums[i];
        for (int j = 1; i + j < n && j <= steps; j++) {
          max = Math.min(max, t[i + j]);
        }
        if (max == Integer.MAX_VALUE) {
          t[i] = Integer.MAX_VALUE;
        } else {
          t[i] = 1 + max;
        }
      }
    }
    return t[0] != Integer.MAX_VALUE;
  }
}