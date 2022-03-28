package com.datastructure.array;

import java.util.HashMap;

public class SubarraySumEquals0 {

  public static void main(String[] args) {
    int[] nums = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
    System.out.println(largestSubarrayLen(nums));
  }

  private static int largestSubarrayLen(int[] nums) {
    int n = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int maxLen = 0;
    map.put(sum, -1);
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (map.containsKey(sum)) {
        maxLen = Math.max(maxLen, i - map.get(sum));
      }
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
    }
    return maxLen;
  }
}
