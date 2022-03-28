package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> lists = new Permutations().permute(nums);
    lists.forEach(list -> {
      list.stream().map(integer -> integer + " ").forEach(System.out::print);
      System.out.println();
    });

  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    permuteUtil(nums, ans, new ArrayList<>());
    return ans;
  }

  private void permuteUtil(int[] nums, List<List<Integer>> ans, List<Integer> subset) {
    if (subset.size() == nums.length) {
      ans.add(new ArrayList<>(subset));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (subset.contains(nums[i])) {
        continue;
      }
      subset.add(nums[i]);
      permuteUtil(nums, ans, subset);
      subset.remove(subset.size() - 1);
    }
  }
}