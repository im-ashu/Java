package com.leetcode;

import java.util.HashMap;

public class ContinuousSubarraySum {

  public static void main(String[] args) {
    int[] nums = {23, 2, 4, 6, 7};
    int k = 6;
    System.out.println(checkSubarraySum(nums, k));
  }

  public static boolean checkSubarraySum(int[] nums, int k) {
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (sum % k == 0 && i > 0) {
        return true;
      }
      int rem = sum % k;
      if (map.containsKey(rem) && i - map.get(rem) > 1) {
        return true;
      }
      if (!map.containsKey(rem)) {
        map.put(rem, i);
      }

    }
    return false;
  }
}
