package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

  public static void main(String[] args) {
    PathSumIII pathSumIII = new PathSumIII();
    Integer[] list = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
    TreeNode root = Deserialize.deserialize(list);
    int targetSum = 8;
    System.out.println(pathSumIII.pathSum(root, targetSum));
  }

  public int pathSum(TreeNode root, int targetSum) {
    Map<Integer, Integer> sumOccurrences = new HashMap<>();
    sumOccurrences.put(0, 1);
    return pathSumUtil(root, targetSum, 0, sumOccurrences);
  }

  private int pathSumUtil(TreeNode root, int targetSum, int currSum,
      Map<Integer, Integer> sumOccurrences) {
    if (root == null) {
      return 0;
    }
    currSum += root.val;
    int res = sumOccurrences.getOrDefault(currSum - targetSum, 0);
    sumOccurrences.put(currSum, sumOccurrences.getOrDefault(currSum, 0) + 1);
    res += pathSumUtil(root.left, targetSum, currSum, sumOccurrences) +
        pathSumUtil(root.right, targetSum, currSum, sumOccurrences);
    sumOccurrences.put(currSum, sumOccurrences.get(currSum) - 1);
    return res;
  }
}
