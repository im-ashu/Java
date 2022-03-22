package com.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class FullBinaryTree {

  public static void main(String[] args) {
    BinaryTree<Integer> b2 = new BinaryTree<>();
    b2.insert(177);
    b2.insert(140);
    b2.insert(183);
    System.out.println(isFullTree(b2.root));
  }

  private static boolean isFullTree(Node node) {
    Queue<Node> q = new LinkedList<>();
    q.add(node);
    while (!q.isEmpty()) {
      Node n = q.poll();
      if (n.left != null && n.right == null) {
        return false;
      } else if (n.right != null && n.left == null) {
        return false;
      }
     if (n.left != null) {
      q.add(n.left);
     }
     if (n.right != null) {
      q.add(n.right);
     }

    }
    return true;
  }
}