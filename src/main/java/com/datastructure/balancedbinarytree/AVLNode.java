package com.datastructure.balancedbinarytree;

public class AVLNode<T extends Comparable<T>> {

  Comparable<?> data;
  AVLNode<?> left;
  AVLNode<?> right;
  int balanceFactor;
  int height;

  AVLNode(T value) {
    data = value;
    left = null;
    right = null;
  }
}