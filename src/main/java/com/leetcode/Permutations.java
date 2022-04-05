package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  List<List<Integer>> lists = new ArrayList<>();

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    Permutations permutations = new Permutations();
    permutations.lists = permutations.permute(nums);
    permutations.lists.forEach(list -> {
      list.stream().map(integer -> integer + " ").forEach(System.out::print);
      System.out.println();
    });
    System.out.println();
    permutations = new Permutations();
    permutations.permuteUtilII(nums, 0);
    permutations.lists.forEach(list -> {
      list.stream().map(integer -> integer + " ").forEach(System.out::print);
      System.out.println();
    });

  }

  public List<List<Integer>> permute(int[] nums) {
    permuteUtil(nums, new ArrayList<>());
    return lists;
  }

  private void permuteUtil(int[] nums, List<Integer> subset) {
    if (subset.size() == nums.length) {
      lists.add(new ArrayList<>(subset));
      return;
    }
    for (int num : nums) {
      if (subset.contains(num)) {
        continue;
      }
      subset.add(num);
      permuteUtil(nums, subset);
      subset.remove(subset.size() - 1);
    }
  }

  private void permuteUtilII(int[] nums, int start) {
    if (start == nums.length) {
      ArrayList<Integer> subset = new ArrayList<>();
      for (int num : nums) {
        subset.add(num);
      }
      lists.add(subset);
      return;
    }
    for (int i = start; i < nums.length; i++) {
      swap(nums, i, start);
      permuteUtilII(nums, start + 1);
      swap(nums, i, start);
    }
  }

  private void swap(int[] nums, int i, int j) {
    if (i != j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}