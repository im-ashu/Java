package com.bitmanipulation;

public class AllAppearTwiceExceptTwo {

  public static void main(String[] args) {
    int[] nums = {1, 2, 1, 2, 4, 3, 3, 5, 6, 6, 0, 0};
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }

    int rmsbm = (xor & -xor);
    int msbNotSet = 0;
    int msbSet = 0;
    for (int num : nums) {
      if ((num & (rmsbm)) == 1) {
        msbSet ^= num;
      } else {
        msbNotSet ^= num;
      }
    }
    System.out.println(msbNotSet + " " + msbSet);
  }
}
