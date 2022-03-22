package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.printLevelOrderTraversal();
  }

  static class Node {

    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
    }
  }

  static class BinaryTree {

    Node root;

    public void printLevelOrderTraversal() {
      if (root == null) {
        return;
      }
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      int nodeCount;
      while (!queue.isEmpty()) {
        nodeCount = queue.size();
        while (nodeCount-- > 0) {
          Node node = queue.poll();
          System.out.printf("%d ", node.data);
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
        System.out.println();
      }
    }
  }

}
