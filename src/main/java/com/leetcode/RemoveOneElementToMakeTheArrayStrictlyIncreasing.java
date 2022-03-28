package com.leetcode;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {

  public static void main(String[] args) {
    int[] nums = {1, 4, 2, 5, 8};
    System.out.println(
        new RemoveOneElementToMakeTheArrayStrictlyIncreasing().canBeIncreasing(nums));

  }

  public boolean canBeIncreasing(int[] nums) {
    int modified = 0, prev = nums[0], index = 1;
    for (; index < nums.length; ++index) {
      if (nums[index] <= prev) {
        if (++modified > 1) {
          return false;
        }
        if (index - 2 >= 0 && nums[index - 2] >= nums[index]) {
          continue;
        }
      }
      prev = nums[index];
    }
    return true;
  }
}
