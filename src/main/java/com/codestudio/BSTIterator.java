package com.codestudio;

import com.leetcode.Deserialize;
import java.util.Stack;

public class BSTIterator {

  private final Stack<TreeNode> n = new Stack<>();
  private final Stack<TreeNode> p = new Stack<>();

  public BSTIterator(TreeNode root) {
    // Write your code here.
    pushLeft(root);
    pushRight(root);
  }

  public static void main(String[] args) {
    String binaryTree = "3 2 4 1 -1 -1 -1 -1 -1";
    TreeNode root = Deserialize.deserialize(binaryTree);
    BSTIterator iterator = new BSTIterator(root);
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    while (iterator.hasPrev()) {
      System.out.print(iterator.prev() + " ");
    }
  }

  public int next() {
    // Write your code here.
    TreeNode current = n.pop();
    if (current.right != null) {
      pushLeft(current.right);
    }
    return current.data;
  }

  public boolean hasNext() {
    // Write your code here.
    return !n.isEmpty();
  }

  public int prev() {
    // Write your code here.
    TreeNode current = p.pop();
    if (current.left != null) {
      pushRight(current.left);
    }
    return current.data;
  }

  public boolean hasPrev() {
    // Write your code here.
    return !p.isEmpty();
  }

  void pushLeft(TreeNode root) {
    while (root != null) {
      n.push(root);
      root = root.left;
    }
  }

  void pushRight(TreeNode root) {
    while (root != null) {
      p.push(root);
      root = root.right;
    }
  }
}
