package com.leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Deserialize {

  public static void main(String[] args) {
    String binaryTree = "3 2 4 1 -1 -1 -1 -1 -1";
    deserialize(binaryTree);
  }

  public static TreeNode deserialize(String binaryTree) {
    String[] values = binaryTree.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    for (int i = 1; i < values.length; i++) {
      TreeNode parent = q.poll();
      if (!Objects.equals(values[i], "-1")) {
        TreeNode left = new TreeNode(Integer.parseInt(values[i]));
        assert parent != null;
        parent.left = left;
        q.add(left);
      }
      if (!Objects.equals(values[++i], "-1")) {
        TreeNode right = new TreeNode(Integer.parseInt(values[i]));
        assert parent != null;
        parent.right = right;
        q.add(right);
      }
    }
    return root;
  }

  public static TreeNode deserialize(Integer[] nums) {
    TreeNode root = new TreeNode(nums[0]);
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int n = nums.length;
    for (int i = 1; i < n; i++) {
      TreeNode rem = q.poll();
      if (nums[i] != null) {
        assert rem != null;
        rem.left = new TreeNode(nums[i]);
        q.add(rem.left);
      }
      if (i < n - 1) {
        if (nums[++i] != null) {
          assert rem != null;
          rem.right = new TreeNode(nums[i]);
          q.add(rem.right);
        }
      }
    }
    return root;
  }
}
