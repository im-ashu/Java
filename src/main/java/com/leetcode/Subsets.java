package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {
    Subsets subsets = new Subsets();
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = subsets.subsets(nums);
    result.forEach(list -> {
      list.stream().map(integer -> integer + " ").forEach(System.out::print);
      System.out.println();
    });
  }

  public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    int totalSubsets = (int) (Math.pow(2, n));
    for (int i = 0; i < totalSubsets; i++) {
      List<Integer> subset = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {
        if ((i & (1 << j)) != 0) {
          subset.add(nums[(j)]);
        }
      }
      result.add(subset);
    }
    return result;
  }
}
