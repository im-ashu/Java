package com.codestudio;

public class LCAOfThreeNodes {

  static class BinaryTreeNode<T> {

    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    String binaryTree = "1 2 3 4 5 6 7 8 9 -1 -1 -1 -1 -1 -1 10 -1 11 -1 -1 -1 -1 -1";
    BinaryTreeNode<Integer> root = Deserialize.deserializeBT(binaryTree);
    int node1 = 8;
    int node2 = 9;
    int node3 = 11;
    BinaryTreeNode<Integer> lca = lcaOfThreeNodes(root, node1, node2, node3);
    System.out.println(lca.data);
  }

  public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1,
      int node2, int node3) {
    if (root == null || root.data == node1 || root.data == node2 || root.data == node3) {
      return root;
    }
    BinaryTreeNode<Integer> left = lcaOfThreeNodes(root.left, node1, node2, node3);
    BinaryTreeNode<Integer> right = lcaOfThreeNodes(root.right, node1, node2, node3);
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    return root;
  }
}
