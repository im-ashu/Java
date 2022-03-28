package com.bitmanipulation;

public class PetrCombinationLock {

  public static void main(String[] args) {
    int[] nums = {10, 20, 30};
    int n = nums.length;
    System.out.println(isPetrCombinationLockPossible(nums, n));
  }

  private static boolean isPetrCombinationLockPossible(int[] nums, int n) {
    int powerSetsCount = (1 << n);
    for (int i = 0; i < powerSetsCount; i++) {
      int sum = 0;
      for (int bit = 0; bit < n; bit++) {
        if ((i & (1 << bit)) > 0) {
          sum += nums[bit];
        } else {
          sum -= nums[bit];
        }
        if (sum % 360 == 0) {
          return true;
        }
      }
    }
    return false;
  }
}
