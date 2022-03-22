package com.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumInBinaryTree extends BinaryTree {

  public static void main(String[] args) {
    MaxLevelSumInBinaryTree binaryTree = new MaxLevelSumInBinaryTree();
    binaryTree.insert(1);
    binaryTree.insert(2);
    binaryTree.insert(3);
    binaryTree.insert(4);
    binaryTree.insert(6);
    binaryTree.insert(5);
    binaryTree.insert(7);
    System.out.println(binaryTree.maxLevelSum(binaryTree.root));
  }

  public int maxLevelSum(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int maxSoFar = Integer.MIN_VALUE;
    while (!q.isEmpty()) {
      int size = q.size();
      int sum = 0;
      while (size-- > 0) {
        Node node = q.poll();
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
        sum += (int) node.data;
      }
      if (sum > maxSoFar) {
        maxSoFar = sum;
      }
    }
    return maxSoFar;
  }

}