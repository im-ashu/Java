package com.datastructure.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfSiblings {

  private static int numberOfSiblings(Node root, int x) {
    if (root == null) {
      return 0;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node parent = queue.poll();
      for (int i = 0; i < parent.child.size(); i++) {
        if (parent.child.get(i).data == x) {
          return parent.child.size() - 1;
        }
        queue.add(parent.child.get(i));
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Node root = new Node(50);
    (root.child).add(new Node(2));
    (root.child).add(new Node(30));
    (root.child).add(new Node(14));
    (root.child).add(new Node(60));
    (root.child.get(0).child).add(new Node(15));
    (root.child.get(0).child).add(new Node(25));
    (root.child.get(0).child.get(1).child).add(new Node(70));
    (root.child.get(0).child.get(1).child).add(new Node(100));
    (root.child.get(1).child).add(new Node(6));
    (root.child.get(1).child).add(new Node(1));
    (root.child.get(2).child).add(new Node(7));
    (root.child.get(2).child.get(0).child).add(new Node(17));
    (root.child.get(2).child.get(0).child).add(new Node(99));
    (root.child.get(2).child.get(0).child).add(new Node(27));
    (root.child.get(3).child).add(new Node(16));

    int x = 100;

    // Function calling
    System.out.println(numberOfSiblings(root, 30));
  }

  static class Node {

    int data;
    List<Node> child;

    public Node(int data) {
      this.data = data;
      this.child = new LinkedList<>();
    }
  }
}
