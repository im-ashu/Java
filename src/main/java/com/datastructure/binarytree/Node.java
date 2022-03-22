package com.datastructure.binarytree;

public class Node<T extends Comparable<T>> {

  T data;
  Node<T> left;
  Node<T> right;

  Node(T data) {
    this.data = data;
  }
}