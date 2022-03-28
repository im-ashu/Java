package com.leetcode;

public class SingleNumberII {

  public static void main(String[] args) {
    int[] nums = {2, 2, 3, 2};
    System.out.println(new SingleNumberII().singleNumber(nums));
  }

  public int singleNumber(int[] nums) {
    int tn = -1;
    int tn1 = 0;
    int tn2 = 0;
    for (int n : nums) {
      int cwtn = tn & n;
      int cwtn1 = tn1 & n;
      int cwtn2 = tn2 & n;

      tn = tn & (~cwtn);
      tn1 = tn1 | cwtn;

      tn1 = tn1 & (~cwtn1);
      tn2 = tn2 | cwtn1;

      tn2 = tn2 & (~cwtn2);
      tn = tn | cwtn2;
    }
    return tn1;
  }
}