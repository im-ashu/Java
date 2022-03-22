package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.root = new Node(1);
    binaryTree.root.left = new Node(2);
    binaryTree.root.right = new Node(3);
    binaryTree.root.left.left = new Node(4);
    binaryTree.root.left.right = new Node(5);
    binaryTree.root.right.right = new Node(8);
    binaryTree.root.right.right.left = new Node(6);
    binaryTree.root.right.right.right = new Node(7);

    /*   Constructed Binary tree is:
                 1
               /   \
             2      3
           /  \      \
          4    5      8
                    /   \
                   6     7    */
    System.out.println("Maximum level sum is " + binaryTree.maxLevelSum());
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

    public int maxLevelSum() {
      if (root == null) {
        return 0;
      }
      int maxSum = Integer.MIN_VALUE;
      Queue<Node> currentLevel = new LinkedList<>();
      currentLevel.add(root);
      while (!currentLevel.isEmpty()) {
        Queue<Node> tempQueue = new LinkedList<>();
        int sum = 0;
        while (!currentLevel.isEmpty()) {
          Node n = currentLevel.poll();
          sum += n.data;
          if (n.left != null) {
            tempQueue.add(n.left);
          }
          if (n.right != null) {
            tempQueue.add(n.right);
          }
        }
        if (sum > maxSum) {
          maxSum = sum;
        }
        currentLevel = tempQueue;
      }
      return maxSum;
    }
  }

}
