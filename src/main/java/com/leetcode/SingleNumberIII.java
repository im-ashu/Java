package com.leetcode;

public class SingleNumberIII {

  public static void main(String[] args) {
    SingleNumberIII number = new SingleNumberIII();
    int[] nums = {1, 2, 1, 3, 2, 5};
    int[] numbers = number.singleNumber(nums);
    System.out.println(numbers[0] + " " + numbers[1]);
  }

  public int[] singleNumber(int[] nums) {
    int n = nums.length;
    int xor = nums[0];
    for (int i = 1; i < n; i++) {
      xor ^= nums[i];
    }
    int rsbm = xor & -xor;
    int xor1 = 0;
    int xor2 = 0;
    for (int num : nums) {
      if ((num & rsbm) == 0) {
        xor1 ^= num;
      } else {
        xor2 ^= num;
      }
    }
    return new int[]{xor1, xor2};
  }

}
