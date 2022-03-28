package com.leetcode;

import java.util.Arrays;

public class CombinationSumIV {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    int target = 35;
    System.out.println(new CombinationSumIV().combinationSum4(nums, target));
  }

  public int combinationSum4(int[] nums, int target) {
    int[] t = new int[target + 1];
    Arrays.fill(t, -1);
    t[0] = 1;
    return combinationSum4Util(nums, target, t);
  }

  private int combinationSum4Util(int[] nums, int target, int[] t) {
    if (t[target] != -1) {
      return t[target];
    }
    int res = 0;
    for (int num : nums) {
      if (target - num < 0) {
        continue;
      }
      res += combinationSum4Util(nums, target - num, t);
    }
    return t[target] = res;
  }

}