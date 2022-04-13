package com.leetcode;

public class MinimumDeletionsMakeArrayBeautiful {

  public static void main(String[] args) {
    MinimumDeletionsMakeArrayBeautiful minimumDeletionsMakeArrayBeautiful = new MinimumDeletionsMakeArrayBeautiful();
    int[] nums = {1, 1, 2, 2, 3, 3};
    System.out.println(minimumDeletionsMakeArrayBeautiful.minDeletion(nums));
  }

  public int minDeletion(int[] nums) {
    int actualIndex = 0;
    int deletion = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (actualIndex % 2 == 0) {
        while (i < n - 1 && nums[i] == nums[i + 1]) {
          i++;
          deletion++;
        }
      }
      actualIndex++;
    }
    if ((n - deletion) % 2 != 0) {
      deletion++;
    }
    return deletion;
  }
}
