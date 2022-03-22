package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KDistanceFromRoot extends BinaryTree<Integer> {

  public static void main(String[] args) {
    KDistanceFromRoot binaryTree = new KDistanceFromRoot();
    binaryTree.insert(1);
    binaryTree.insert(2);
    binaryTree.insert(3);
    binaryTree.insert(4);
    binaryTree.insert(6);
    binaryTree.insert(5);
    binaryTree.insert(7);
    int k = 5;
    ArrayList<Integer> result = binaryTree.Kdistance(binaryTree.root, k);
    result.forEach(e -> System.out.print(e + " "));
  }

  ArrayList<Integer> Kdistance(Node<?> root, int k) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<Node<?>> q = new LinkedList<>();
    q.add(root);
    ArrayList<Integer> result;
    while (!q.isEmpty()) {
      int size = q.size();
      result = new ArrayList<>();
      k--;
      while (size-- > 0) {
        Node<?> node = q.poll();
        assert node != null;
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
        result.add((Integer) node.data);
      }
      if (k < 0) {
        return result;
      }
    }
    return new ArrayList<>();
  }
}