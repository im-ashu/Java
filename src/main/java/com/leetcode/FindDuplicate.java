package com.leetcode;

public class FindDuplicate {

  public static void main(String[] args) {
    int[] nums = {1, 1, 2};
    System.out.println(new FindDuplicate().findDuplicate(nums));
    System.out.println(new FindDuplicate().findDuplicateII(nums));
  }

  private int findDuplicateII(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    do {
      fast = nums[nums[fast]];
      slow = nums[slow];
    } while (fast != slow);
    fast = nums[0];
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return fast;
  }

  public int findDuplicate(int[] nums) {
    int n = nums.length;
    int i = 0;
    while (i < n) {
      if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]) {
        i++;
      } else if (nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      } else {
        i++;
      }
    }
    i = 0;
    while (i < n && nums[i] == i + 1) {
      i++;
    }
    return nums[i];
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


}
