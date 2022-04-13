package com.leetcode;

class Node {

  int val;
  Node next;
  Node random;
  Node right;
  Node left;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
    this.left = null;
    this.right = null;
  }
}