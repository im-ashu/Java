package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

  public static void main(String[] args) {
    MajorityElementII majorityElementII = new MajorityElementII();
    int[] nums = {1};
    List<Integer> majorityElements = majorityElementII.majorityElement(nums);
    majorityElements.stream().map(element -> element + " ").forEach(System.out::print);

  }

  public List<Integer> majorityElement(int[] nums) {
    int num1 = -1;
    int num2 = -1;
    int c1 = 0;
    int c2 = 0;
    int n = nums.length;
    for (int num : nums) {
      if (num1 == num) {
        c1++;
      } else if (num2 == num) {
        c2++;
      } else if (c1 == 0) {
        num1 = num;
        c1 = 1;
      } else if (c2 == 0) {
        num2 = num;
        c2 = 1;
      } else {
        c1--;
        c2--;
      }
    }
    c1 = 0;
    c2 = 0;
    for (int num : nums) {
      if (num == num1) {
        c1++;
      } else if (num == num2) {
        c2++;
      }
    }
    List<Integer> res = new ArrayList<>();
    if (c1 > (n / 3)) {
      res.add(num1);
    }
    if (c2 > (n / 3)) {
      res.add(num2);
    }
    return res;
  }
}
