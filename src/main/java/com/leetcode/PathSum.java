package com.leetcode;

public class PathSum {

  public static void main(String[] args) {
    PathSum pathSum = new PathSum();
    Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
    TreeNode root = Deserialize.deserialize(nums);
    int targetSum = 22;
    System.out.println(pathSum.hasPathSum(root, targetSum));
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return root.val == targetSum;
    }
    int remSum = targetSum - root.val;
    return hasPathSum(root.left, remSum) || hasPathSum(root.right, remSum);
  }
}
