package com.datastructure.dynamicprogramming.tree;

public class DiameterOfTree {

  static Node newNode(int data) {
    Node node = new Node();
    node.data = data;
    node.left = null;
    node.right = null;
    return (node);
  }

  public static void main(String[] args) {
    Node root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);

    System.out.println("Diameter is " + diameter(root));
  }

  private static int diameter(Node root) {
    if (root == null) {
      return 0;
    }
    Result result = new Result();
    height(root, result);
    return result.ans;
  }

  private static int height(Node node, Result result) {
    if (node == null) {
      return 0;
    }
    int leftHeight = height(node.left, result);
    int rightHeight = height(node.right, result);
    int height = 1 + Math.max(leftHeight, rightHeight);
    int diameter = Math.max(result.ans, 1 + leftHeight + rightHeight);
    result.ans = diameter;
    return height;
  }

  static class Node {

    int data;
    Node left, right;
  }

  static class Result {

    int ans = Integer.MIN_VALUE;
  }
}