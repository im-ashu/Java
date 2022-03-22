package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);

    System.out.println(isCompleteBinaryTree(root) ? "YES" : "NO");
  }

  private static boolean isCompleteBinaryTree(Node root) {
    if (root == null) {
      return true;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    boolean flag = false;
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.left != null) {
        if (flag) {
          return false;
        }
        queue.add(node.left);
      } else {
        flag = true;
      }
      if (node.right != null) {
        if (flag) {
          return false;
        }
        queue.add(node.right);
      } else {
        flag = true;
      }
    }
    return true;
  }

  static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }
}
