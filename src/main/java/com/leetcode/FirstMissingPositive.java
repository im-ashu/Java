package com.leetcode;

public class FirstMissingPositive {

  public static void main(String[] args) {
    int[] nums = {7, 8,};
    System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
  }

  public int firstMissingPositive(int[] nums) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
      if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length ||
          (nums[i] == nums[nums[i] - 1])) {
        i++;
      } else if (nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }
    i = 0;
    while (i < n && nums[i] == i + 1) {
      i++;
    }
    return i + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
