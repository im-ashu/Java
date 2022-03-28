package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    final List<List<Integer>> lists = threeSum(nums);
    for (List<Integer> list : lists) {
      for (Integer integer : list) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }

  }

  private static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i + 2 < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int l = i + 1;
      int r = nums.length - 1;
      while (l < r) {
        int sum = nums[l] + nums[r] + nums[i];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[l], nums[r]));
          r--;

          while (l < r && nums[r] == nums[r + 1]) {
            r--;
          }
        } else if (sum > 0) {
          r--;
        } else {
          l++;
        }
      }
    }
    return result;
  }
}