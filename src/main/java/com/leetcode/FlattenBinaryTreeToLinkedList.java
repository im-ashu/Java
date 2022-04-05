package com.leetcode;

public class FlattenBinaryTreeToLinkedList {

  public static void main(String[] args) {
    FlattenBinaryTreeToLinkedList tree = new FlattenBinaryTreeToLinkedList();
    Integer[] nums = {1, 2};
    TreeNode root = Deserialize.deserialize(nums);
    tree.flatten(root);
    TreeNode current = root;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.right;
    }

  }

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode current = root;
    while (current != null) {
      if (current.left != null) {
        TreeNode prev = current.left;
        while (prev.right != null) {
          prev = prev.right;
        }
        prev.right = current.right;
        current.right = current.left;
        current.left = null;
      }
      current = current.right;
    }
  }

}
