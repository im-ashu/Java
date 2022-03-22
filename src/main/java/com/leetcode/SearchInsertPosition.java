package com.leetcode;

public class SearchInsertPosition {

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 6};
    int target = 7;
    System.out.println(new SearchInsertPosition().searchInsert(nums, target));
  }

  public int searchInsert(int[] nums, int target) {
    int l = 0;
    int h = nums.length - 1;
    int ceilIndex = nums.length;
    while (l <= h) {
      int mid = l + ((h - l) >> 1);
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        ceilIndex = mid;
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return ceilIndex;
  }
}
