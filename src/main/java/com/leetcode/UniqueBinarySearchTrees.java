package com.leetcode;

public class UniqueBinarySearchTrees {

  public static void main(String[] args) {
    UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
    int n = 3;
    System.out.println(uniqueBinarySearchTrees.numTrees(n));
  }

  public int numTrees(int n) {
    int[] t = new int[n + 1];
    t[0] = 1;
    t[1] = 1;
    for (int i = 2; i <= n; i++) {
      int left = 0;
      int right = i - 1;
      while (right >= 0) {
        t[i] += t[left] * t[right];
        left++;
        right--;
      }
    }
    return t[n];
  }
}
