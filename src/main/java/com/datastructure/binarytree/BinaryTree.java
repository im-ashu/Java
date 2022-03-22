package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTree<T extends Comparable<T>> {

  Node<T> root;
  int nodeCount;

  public int size() {
    return nodeCount;
  }

  public boolean contains(T data) {
   if (data == null) {
    return false;
   }
    return contains(root, data);

  }

  private boolean contains(Node<T> node, T data) {
   if (node == null) {
    return false;
   }
    int compareValue = data.compareTo(node.data);
    if (compareValue < 0) {
      return contains(node.left, data);
    } else if (compareValue > 0) {
      return contains(node.right, data);
    }
    return true;
  }

  public boolean insert(T data) {
    if (data == null) {
      return false;
    }
    if (!contains(data)) {
      root = insert(root, data);
      nodeCount++;
      return true;
    }
    return false;
  }

  private Node<T> insert(Node<T> node, T data) {
   if (node == null) {
    return new Node<>(data);
   }
    int compareValue = data.compareTo(node.data);
   if (compareValue < 0) {
    node.left = insert(node.left, data);
   } else {
    node.right = insert(node.right, data);
   }
    return node;
  }

  public boolean remove(T data) {
   if (data == null) {
    return false;
   }
    if (contains(data)) {
      root = remove(root, data);
      nodeCount--;
      return true;
    }
    return false;
  }

  private Node<T> remove(Node<T> node, T data) {
   if (node == null) {
    return null;
   }
    int compareValue = data.compareTo(node.data);
    if (compareValue < 0) {
      node.left = remove(node.left, data);
    } else if (compareValue > 0) {
      node.right = remove(node.right, data);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      } else {
        Node<T> successorNode = findMax(node.left);
        node.data = successorNode.data;
        node.left = remove(node.left, data);
      }
    }
    return node;
  }

  private Node<T> findMax(Node<T> node) {
   while (node.right != null) {
    node = node.right;
   }
    return node;
  }

  public void levelOrderTraversal() {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int maxSoFar = Integer.MIN_VALUE;
    while (!q.isEmpty()) {
      int size = q.size();
      int sum = 0;
      while (size-- > 0) {
        Node node = q.poll();
        if (Objects.requireNonNull(node).left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
        sum += (int) node.data;
      }
      if (sum > maxSoFar) {
        maxSoFar = sum;
      }
    }
  }

  public List<List<Integer>> zigzagLevelOrder(Node root) {
    List<List<Integer>> result = new LinkedList<>();
    if (root == null) {
      return result;
    }
    boolean leftToRight = true;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      LinkedList<Integer> innerList = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        final Node node = q.poll();
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
        if (leftToRight) {
          innerList.addLast((Integer) node.data);
        } else {
          innerList.addFirst((Integer) node.data);
        }
      }
      result.add(innerList);
      leftToRight = !leftToRight;
    }
    return result;
  }

  public List<List<Integer>> verticalOrderTraversal(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0, 0));
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    while (!q.isEmpty()) {
      int size = q.size();
      TreeMap<Integer, PriorityQueue<Integer>> t = new TreeMap<>();
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for (int i = 0; i < size; i++) {
        final Pair remove = q.remove();
        if (remove.n.left != null) {
          q.add(new Pair(remove.n.left, remove.vertical - 1, remove.level + 1));
        }
        if (remove.n.right != null) {
          q.add(new Pair(remove.n.right, remove.vertical + 1, remove.level + 1));
        }
        if (!map.containsKey(remove.vertical)) {
          map.put(remove.vertical, new TreeMap<>());
        }
        if (!map.get(remove.vertical).containsKey(remove.level)) {
          map.get(remove.vertical).put(remove.level, new PriorityQueue<>());
        }
        map.get(remove.vertical).get(remove.level).add((Integer) remove.n.data);
      }
    }

    for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
      ans.add(new ArrayList<>());
      for (PriorityQueue<Integer> integers : ys.values()) {
        while (!integers.isEmpty()) {
          ans.get(ans.size() - 1).add(integers.poll());
        }
      }

    }
    return ans;
  }

  class Pair {

    Node n;
    int vertical;
    int level;

    public Pair(Node n, int vertical, int level) {
      this.n = n;
      this.vertical = vertical;
      this.level = level;
    }
  }

}