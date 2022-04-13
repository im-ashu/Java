package com.leetcode;

public class ValidateBinarySearchTree {

  public static void main(String[] args) {
    ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
    Integer[] list = {2, 1, 3};
    TreeNode root = Deserialize.deserialize(list);
    System.out.println(validateBinarySearchTree.isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBSTUtil(TreeNode root, long minValue, long maxValue) {
    if (root == null) {
      return true;
    }
    if (root.val <= minValue || root.val >= maxValue) {
      return false;
    }
    return isValidBSTUtil(root.left, minValue, root.val) && isValidBSTUtil(root.right, root.val,
        maxValue);
  }
}
