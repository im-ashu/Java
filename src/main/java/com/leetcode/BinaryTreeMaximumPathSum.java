package com.leetcode;

public class BinaryTreeMaximumPathSum {

  public static void main(String[] args) {
    BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum();
    Integer[] nums = {-10, 9, 20, null, null, 15, 7};
    TreeNode root = Deserialize.deserialize(nums);
    System.out.println(tree.maxPathSum(root));
  }

  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] ans = new int[]{root.val};
    maxPathSumUtil(root, ans);
    return ans[0];
  }

  private int maxPathSumUtil(TreeNode root, int[] ans) {
    if (root == null) {
      return 0;
    }
    int leftSum = maxPathSumUtil(root.left, ans);
    int rightSum = maxPathSumUtil(root.right, ans);
    int maxSingle = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
    int maxSoFar = Math.max(maxSingle, root.val + leftSum + rightSum);
    ans[0] = Math.max(ans[0], maxSoFar);
    return maxSingle;
  }
}
