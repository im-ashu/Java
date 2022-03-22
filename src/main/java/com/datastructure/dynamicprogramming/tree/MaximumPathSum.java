package com.datastructure.dynamicprogramming.tree;

public class MaximumPathSum {

  static Node newNode(int data) {
    Node node = new Node();
    node.data = data;
    node.left = null;
    node.right = null;
    return (node);
  }

  public static void main(String[] args) {
    Node root = newNode(10);
    root.left = newNode(2);
    root.right = newNode(10);
    root.left.left = newNode(-20);
    root.left.right = newNode(-1);
    root.right.right = newNode(-25);
    root.right.right.left = newNode(-3);
    root.right.right.right = newNode(-4);
    Result result = new Result();
    maxPathSumFromAnyNodeToAnyNode(root, result);
    System.out.println("Max Path sum From Any node is " + result.ans);
    result = new Result();
    maxPathSumFromLeafToLeaf(root, result);
    System.out.println("Max Path sum From Leaf node is " + result.ans);
  }

  private static int maxPathSumFromAnyNodeToAnyNode(Node root, Result result) {
    if (root == null) {
      return 0;
    }
    int leftSum = maxPathSumFromAnyNodeToAnyNode(root.left, result);
    int rightSum = maxPathSumFromAnyNodeToAnyNode(root.right, result);
    int maxSingle = Math.max(Math.max(leftSum, rightSum) + root.data,
        root.data);
    int maxTop = Math.max(maxSingle, leftSum + rightSum + root.data);
    result.ans = Math.max(result.ans, maxTop);
    return maxSingle;
  }

  private static int maxPathSumFromLeafToLeaf(Node root, Result result) {
    if (root == null) {
      return 0;
    }
    int leftSum = maxPathSumFromLeafToLeaf(root.left, result);
    int rightSum = maxPathSumFromLeafToLeaf(root.right, result);
    int maxSingle = Math.max(leftSum, rightSum) + root.data;
// if (root.left == null && root.right == null)
// {
// maxSingle = Math.max(maxSingle, root.data);
// }
    int maxTop = Math.max(maxSingle, leftSum + rightSum + root.data);
    result.ans = Math.max(result.ans, maxTop);
    return maxSingle;
  }

  static class Node {

    int data;
    Node left, right;
  }

  static class Result {

    int ans = Integer.MIN_VALUE;
  }
}