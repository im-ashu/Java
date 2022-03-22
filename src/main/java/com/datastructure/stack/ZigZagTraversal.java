package com.datastructure.stack;

import java.util.Stack;

public class ZigZagTraversal {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.root = new Node(1);
    binaryTree.root.left = new Node(2);
    binaryTree.root.right = new Node(3);
    binaryTree.root.left.left = new Node(7);
    binaryTree.root.left.right = new Node(6);
    binaryTree.root.right.left = new Node(5);
    binaryTree.root.right.right = new Node(4);

    System.out.println("ZigZag Order traversal of binary binaryTree is");
    binaryTree.zigZagTraversal();
    System.out.println();
  }

  static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }

  static class BinaryTree {

    Node root;

    public void zigZagTraversal() {
      if (root == null) {
        return;
      }
      Stack<Node> currentLevelStack = new Stack<>();
      Stack<Node> nextLevelStack = new Stack<>();
      boolean leftToRight = false;
      currentLevelStack.push(root);
      while (!currentLevelStack.isEmpty()) {
        Node parent = currentLevelStack.pop();
        System.out.printf("%d ", parent.data);
        if (leftToRight) {
          if (parent.right != null) {
            nextLevelStack.push(parent.right);
          }
          if (parent.left != null) {
            nextLevelStack.push(parent.left);
          }
        } else {
          if (parent.left != null) {
            nextLevelStack.push(parent.left);
          }
          if (parent.right != null) {
            nextLevelStack.push(parent.right);
          }
        }
        if (currentLevelStack.isEmpty()) {
          leftToRight = !leftToRight;
          Stack<Node> tempStack = currentLevelStack;
          currentLevelStack = nextLevelStack;
          nextLevelStack = tempStack;
        }
      }
    }
  }

}
