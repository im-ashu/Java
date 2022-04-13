package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

  public static void main(String[] args) {
    int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    for (List<Integer> list : new CombinationSumII().combinationSum2(candidates, target)) {
      for (Integer numbers : list) {
        System.out.print(numbers + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum2Util(new ArrayList<>(), result, candidates, target, 0);
    return result;
  }

  private void combinationSum2Util(ArrayList<Integer> subset, List<List<Integer>> result,
      int[] candidates, int target, int start) {
    if (target == 0) {
      result.add(new ArrayList<>(subset));
      return;
    }
    for (int i = start, len = candidates.length; i < len; i++) {
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      if (candidates[i] <= target) {
        subset.add(candidates[i]);
        combinationSum2Util(subset, result, candidates, target - candidates[i], i + 1);
        subset.remove(subset.size() - 1);
      }
    }
  }
}
