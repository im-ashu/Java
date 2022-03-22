package com.datastructure.dynamicprogramming.unboundedknapsack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumWithReUsingNumbers {

  public static void main(String[] args) {
    int[] candidates = {2, 5, 2, 1, 2};
    int target = 5;
    for (List<Integer> list : new CombinationSumWithReUsingNumbers().combinationSum(candidates,
        target)) {
      for (Integer numbers : list) {
        System.out.print(numbers + " ");
      }
      System.out.println();
    }

  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates.length == 0) {
      return res;
    }
    combinationSum(candidates, target, 0, res, new ArrayList<>());
    return res;
  }

  private void combinationSum(int[] candidates, int target, int index, List<List<Integer>> res,
      List<Integer> subset) {
    if (target == 0) {
      res.add(new ArrayList<>(subset));
      return;
    }
    if (target < 0) {
      return;
    }
    for (int i = index, candidatesLength = candidates.length; i < candidatesLength; i++) {
      subset.add(candidates[i]);
      combinationSum(candidates, target - candidates[i], i + 1, res, subset);
      subset.remove(subset.size() - 1);
    }
  }
}