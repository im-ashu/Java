package com.leetcode;

public class SameTree {

  public static void main(String[] args) {

    TreeNode p = Deserialize.deserialize(new Integer[]{1, 2, 3});
    TreeNode q = Deserialize.deserialize(new Integer[]{1, 2, 3});
    System.out.println(new SameTree().isSameTree(p, q));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == q;
    }

    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

}
