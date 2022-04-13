package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode {

  public static Node deserialize(Integer[] nums) {
    Node root = new Node(nums[0]);
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int n = nums.length;
    for (int i = 1; i < n; i++) {
      Node rem = q.poll();
      if (nums[i] != null) {
        assert rem != null;
        rem.left = new Node(nums[i]);
        q.add(rem.left);
      }
      if (i < n - 1) {
        if (nums[++i] != null) {
          assert rem != null;
          rem.right = new Node(nums[i]);
          q.add(rem.right);
        }
      }
    }
    return root;
  }

  public static void main(String[] args) {
    PopulatingNextRightPointersEachNode populatingNextRightPointersEachNode = new PopulatingNextRightPointersEachNode();
    Integer[] list = {1, 2, 3, 4, 5, 6, 7};
    Node head = deserialize(list);
    head = populatingNextRightPointersEachNode.connect(head);

  }

  public Node connect(Node root) {
    Node current = root;
    while (current != null) {
      Node head = null;
      Node prev = null;
      while (current != null) {
        if (current.left != null) {
          if (prev == null) {
            head = current.left;
          } else {
            prev.next = current.left;
          }
          prev = current.left;
        }
        if (current.right != null) {
          if (prev == null) {
            head = current.right;
          } else {
            prev.next = current.right;
          }
          prev = current.right;
        }
        current = current.next;
      }
      current = head;
    }
    return root;
  }
}
