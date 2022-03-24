package com.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class IsIdentical {

  public static void main(String[] args) {
    BinaryTree<Integer> b1 = new BinaryTree<>();
    BinaryTree<Integer> b2 = new BinaryTree<>();
    b1.insert(177);
    b2.insert(177);
    b1.insert(183);
    b2.insert(183);
    System.out.println(isIdentical(b1.root, b2.root));
  }

  static boolean isIdentical(Node<?> root1, Node<?> root2) {
    // Code Here
    Queue<Node<?>> q1 = new LinkedList<>();
    Queue<Node<?>> q2 = new LinkedList<>();
    q1.add(root1);
    q2.add(root2);
    while (!q1.isEmpty() && !q2.isEmpty()) {
      Node<?> node1 = q1.poll();
      Node<?> node2 = q2.poll();
      if (!node1.data.equals(Objects.requireNonNull(node2).data)) {
        return false;
      }
      if (node1.left != null) {
        q1.add(node1.left);
      }
      if (node1.right != null) {
        q1.add(node1.right);
      }
      if (node2.left != null) {
        q2.add(node2.left);
      }
      if (node2.right != null) {
        q2.add(node2.right);
      }
    }
    return q1.isEmpty() && q2.isEmpty();
  }
}