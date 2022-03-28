package com.leetcode;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
    int[] nums = {1, 1, 2};
    System.out.println(r.removeDuplicates(nums));
  }

  public int removeDuplicates(int[] nums) {
    int j = 0;
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] != nums[i + 1]) {
        nums[++j] = nums[i + 1];
      }
    }
    return j + 1;
  }
}