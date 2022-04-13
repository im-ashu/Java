package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

  public static void main(String[] args) {
    PathSumII pathSumII = new PathSumII();
    Integer[] lists = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
    TreeNode root = Deserialize.deserialize(lists);
    int targetSum = 22;
    List<List<Integer>> result = pathSumII.pathSum(root, targetSum);
    for (List<Integer> path : result) {
      for (Integer node : path) {
        System.out.print(node + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    pathSumUtil(res, new ArrayList<>(), root, targetSum);
    return res;
  }

  private void pathSumUtil(List<List<Integer>> res, ArrayList<Integer> subset, TreeNode root,
      int targetSum) {

    if (root == null) {
      return;
    }
    subset.add(root.val);
    if (root.left == null && root.right == null && targetSum == root.val) {
      res.add(new ArrayList<>(subset));
      return;
    }
    if (root.left != null) {
      pathSumUtil(res, subset, root.left, targetSum - root.val);
      subset.remove(subset.size() - 1);
    }
    if (root.right != null) {
      pathSumUtil(res, subset, root.right, targetSum - root.val);
      subset.remove(subset.size() - 1);
    }

  }

}
