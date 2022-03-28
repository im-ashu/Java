package com.leetcode;

public class MaxConsecutiveOnesIII {

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    int k = 0;
    System.out.println(new MaxConsecutiveOnesIII().longestOnes(nums, k));
  }

  public int longestOnes(int[] nums, int k) {
    int end = 0;
    int begin = 0;
    int maxLength = 0;
    int count0s = 0;
    int n = nums.length;
    while (end < n) {
     if (nums[end] == 0) {
      count0s++;
     }
      while (count0s > k) {
        if (nums[begin] == 0) {
          count0s--;
        }
        begin++;
      }
      maxLength = Math.max(maxLength, end - begin + 1);
      end++;
    }
    return maxLength;
  }
}