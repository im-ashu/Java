package com.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int n = nums.length;
    List<List<Integer>> subsets = generateSubsets(nums, n);
    for (List<Integer> subset : subsets) {
      for (Integer num : subset) {
        System.out.print(num + " ");
      }
      System.out.println();
    }

  }

  private static List<List<Integer>> generateSubsets(int[] nums, int n) {
    List<List<Integer>> subsets = new ArrayList<>();
    int totalSubsets = (1 << n);
    for (int i = 0; i < totalSubsets; i++) {
      subsets.add(new ArrayList<>());
      for (int bit = 0; bit < n; bit++) {
        if ((i & (1 << bit)) > 0) {
          subsets.get(subsets.size() - 1).add(nums[bit]);
        }
      }
    }
    return subsets;
  }
}
