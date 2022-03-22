package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertList2Binary {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.push(36); /* Last Node of Linked List */
    binaryTree.push(30);
    binaryTree.push(25);
    binaryTree.push(15);
    binaryTree.push(12);
    binaryTree.push(10); /* Head of Linked List */
    BinaryTreeNode root = binaryTree.convertList2BinaryTree();
    binaryTree.inOrderTraversal(root);
  }

  static class ListNode {

    int data;
    ListNode next;

    public ListNode(int data) {
      this.data = data;
    }
  }

  static class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
      this.data = data;
    }
  }

  static class BinaryTree {

    ListNode head;
    BinaryTreeNode root;

    public void push(int data) {
      ListNode node = new ListNode(data);
      node.next = head;
      head = node;
    }

    public BinaryTreeNode convertList2BinaryTree() {
      BinaryTreeNode node;
      if (head == null) {
        root = null;
        return null;
      }
      Queue<BinaryTreeNode> queue = new LinkedList<>();
      node = new BinaryTreeNode(head.data);
      root = node;
      queue.add(node);
      head = head.next;
      while (head != null) {
        BinaryTreeNode parent = queue.poll();
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild = null;
        leftChild = new BinaryTreeNode(head.data);
        queue.offer(leftChild);
        head = head.next;
        if (head != null) {
          rightChild = new BinaryTreeNode(head.data);
          queue.offer(rightChild);
          head = head.next;
        }
        assert parent != null;
        parent.left = leftChild;
        parent.right = rightChild;
      }
      return root;
    }

    public void inOrderTraversal(BinaryTreeNode root) {
      if (root == null) {
        return;
      }
      inOrderTraversal(root.left);
      System.out.printf("%d ", root.data);
      inOrderTraversal(root.right);
    }
  }

}
