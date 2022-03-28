package com.leetcode;

import java.util.Arrays;

public class SortColors {

  public static void main(String[] args) {
    int[] nums = {2, 0, 2, 1, 1, 0};
    new SortColors().sortColors(nums);
    Arrays.stream(nums).forEachOrdered(i -> System.out.print(i + " "));
  }

  public void sortColors(int[] nums) {
    int[] count = new int[3];
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      count[nums[i]]++;
    }
    int[] b = new int[n];
    for (int i = 1; i < 3; i++) {
      count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
      b[--count[nums[i]]] = nums[i];
    }
    for (int i = 0; i < n; i++) {
      nums[i] = b[i];
    }
  }

  void sortColorsII(int A[], int n) {
    int n0 = -1, n1 = -1, n2 = -1;
    for (int i = 0; i < n; ++i) {
      if (A[i] == 0) {
        A[++n2] = 2;
        A[++n1] = 1;
        A[++n0] = 0;
      } else if (A[i] == 1) {
        A[++n2] = 2;
        A[++n1] = 1;
      } else if (A[i] == 2) {
        A[++n2] = 2;
      }
    }
  }

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  ;
}