package com.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPosition {

  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    Arrays.stream(new FindFirstAndLastPosition().searchRange(nums, target)).mapToObj(i -> i + " ")
        .forEach(System.out::print);

  }

  public int[] searchRange(int[] nums, int target) {
    int first = -1;
    int last = -1;
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] == target) {
        first = mid;
        high = mid - 1;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (first == -1) {
      return new int[]{-1, -1};
    }
    low = 0;
    high = nums.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] == target) {
        last = mid;
        low = mid + 1;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return new int[]{first, last};
  }
}