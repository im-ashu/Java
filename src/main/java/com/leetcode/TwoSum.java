package com.leetcode;

import java.util.HashMap;

public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;
    final int[] res = twoSum(nums, target);
    System.out.println("[" + res[0] + ", " + res[1] + "]");
  }

  public static int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    int n = nums.length;
    HashMap<Integer, Integer> s = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (s.containsKey(target - nums[i])) {
        res[0] = s.get(target - nums[i]);
        res[1] = i;
        break;
      }
      s.put(nums[i], i);
    }
    return res;
  }
}