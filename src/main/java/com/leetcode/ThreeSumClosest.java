package com.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

  public static void main(String[] args) {
    int[] nums = {-1, 2, 1, -4};
    int target = 1;
    System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    int minDiff = Integer.MAX_VALUE;
    int res = target;
    for (int i = 0; i < n - 1; i++) {
      int low = i + 1;
      int high = n - 1;
      while (low < high) {
        int curr = nums[i] + nums[low] + nums[high];
        if (Math.abs(target - curr) < minDiff) {
          minDiff = Math.abs(target - curr);
          res = curr;
        }
        if (curr > target) {
          high--;
        } else {
          low++;
        }
      }
    }
    return res;

  }

}
