package com.leetcode;

public class SearchInRotatedSortedArrayII {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
    int target = 2;
    System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
  }

  public boolean search(int[] nums, int target) {
    return searchUtil(nums, target, 0, nums.length - 1);
  }

  private boolean searchUtil(int[] nums, int target, int low, int high) {
    if (low > high) {
      return false;
    }
    int mid = low + ((high - low) >> 1);
    if (nums[mid] == target) {
      return true;
    }
    if (nums[low] < nums[mid] || nums[mid] > nums[high]) {
      if (target >= nums[low] && target < nums[mid]) {
        return searchUtil(nums, target, low, mid - 1);
      } else {
        return searchUtil(nums, target, mid + 1, high);
      }
    } else if (nums[mid] < nums[high] || nums[mid] < nums[low]) {
      if (target <= nums[high] && target > nums[mid]) {
        return searchUtil(nums, target, mid + 1, high);
      } else {
        return searchUtil(nums, target, low, mid - 1);
      }
    }
    return searchUtil(nums, target, low, high - 1);
  }
}
