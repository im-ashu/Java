package com.leetcode;


public class RecoverBinarySearchTree {

  TreeNode prev = new TreeNode(Integer.MIN_VALUE);
  TreeNode first, mid, last;

  public static void main(String[] args) {
    Integer[] nums = {1, 3, null, null, 2};
    TreeNode root = Deserialize.deserialize(nums);
    RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
    recoverBinarySearchTree.recoverTree(root);
    recoverBinarySearchTree.morrisTraversal(root);
  }

  private void morrisTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.print(current.val + " ");
        current = current.right;
      } else {
        TreeNode prev = current.left;
        while (prev.right != null && prev.right != current) {
          prev = prev.right;
        }
        if (prev.right == null) {
          prev.right = current;
          current = current.left;
        } else {
          System.out.print(current.val + " ");
          current = current.right;
          prev.right = null;
        }
      }
    }
  }

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    if (prev.val > root.val) {
      if (first == null) {
        first = prev;
        mid = root;
      } else {
        last = root;
      }
    }
    prev = root;
    inOrder(root.right);
  }

  public void recoverTree(TreeNode root) {
    inOrder(root);
    int temp = first.val;
    if (last != null) {
      first.val = last.val;
      last.val = temp;
    } else {
      first.val = mid.val;
      mid.val = temp;
    }
  }
}
