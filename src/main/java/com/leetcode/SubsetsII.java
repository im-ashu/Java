package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

  public static void main(String[] args) {
    SubsetsII subsetsII = new SubsetsII();
    int[] nums = {1, 4, 4,};
    List<List<Integer>> subsetsWithDup = subsetsII.subsetsWithDup(nums);
    for (List<Integer> subset : subsetsWithDup) {
      for (Integer element : subset) {
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    subsetsWithDupUtil(nums, 0, res, new ArrayList<>());
    return res;
  }

  private void subsetsWithDupUtil(int[] nums, int start, List<List<Integer>> res,
      List<Integer> subset) {
    res.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      subset.add(nums[i]);
      subsetsWithDupUtil(nums, i + 1, res, subset);
      subset.remove(subset.size() - 1);
    }
  }
}
