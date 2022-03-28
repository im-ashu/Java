package com.datastructure.disjointset;

import java.util.HashMap;

public class UnionFind {

  private final int totalElements;
  private final int[] size;
  private final int[] id;
  private int numComponents;

  public UnionFind(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Size <=0 is not allowed");
    }
    this.totalElements = size;
    this.numComponents = size;
    this.size = new int[size];
    this.id = new int[size];
    for (int i = 0; i < size; i++) {
      this.size[i] = 1;
      this.id[i] = i;
    }
  }

  public static void main(String[] args) {
    int size = 4;
    HashMap<Character, Integer> hm = new HashMap<>();
    hm.put('A', 0);
    hm.put('B', 1);
    hm.put('C', 2);
    hm.put('D', 3);

    UnionFind u = new UnionFind(size);
    u.union(hm.get('A'), hm.get('B'));
    u.union(hm.get('C'), hm.get('D'));
    System.out.println(
        "Is C and D connected - " + (u.connected(hm.get('D'), hm.get('C')) ? "Yes" : "No"));
    // u.union(hm.get('D'), hm.get('B'));
    System.out.println(
        "Is A and C connected - " + (u.connected(hm.get('A'), hm.get('C')) ? "Yes" : "No"));
  }

  public int find(int p) {
    int root = p;
    while (root != id[root]) {
      root = id[root];
    }
    while (p != root) {
      int parentOfP = id[p];
      id[p] = root;
      p = parentOfP;
    }
    return root;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int componentSize(int p) {
    return size[find(p)];
  }

  public int size() {
    return this.totalElements;
  }

  public int components() {
    return numComponents;
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      return;
    }
    if (size[rootQ] > size[rootP]) {
      size[rootQ] += size[rootP];
      id[rootP] = rootQ;

    } else {
      size[rootP] += size[rootQ];
      id[rootQ] = rootP;
    }
    numComponents--;
  }
}