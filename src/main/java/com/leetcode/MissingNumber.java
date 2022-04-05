package com.leetcode;

public class MissingNumber {

  public static void main(String[] args) {
    MissingNumber missingNumber = new MissingNumber();
    int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    System.out.println(missingNumber.missingNumber(nums));
  }

  public int missingNumber(int[] nums) {
    int xor = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      xor = xor ^ i ^ nums[i];
    }
    xor ^= n;
    return xor;
  }

}
