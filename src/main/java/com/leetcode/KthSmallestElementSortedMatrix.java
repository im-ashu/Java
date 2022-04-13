package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

  public static void main(String[] args) {
    KthSmallestElementSortedMatrix kthSmallestElementSortedMatrix = new KthSmallestElementSortedMatrix();
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    int k = 8;
    System.out.println(kthSmallestElementSortedMatrix.kthSmallest(matrix, k));
  }

  public int kthSmallest(int[][] matrix, int k) {
    int m = matrix[0].length;
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    for (int i = 0; i < m; i++) {
      maxHeap.add(new int[]{i, 0, matrix[i][0]});
    }
    for (int i = 0; i < k - 1; i++) {
      int[] rem = maxHeap.poll();
      assert rem != null;
      if (rem[1] == m - 1) {
        continue;
      }
      int y = rem[1] + 1;
      int val = matrix[rem[0]][y];
      maxHeap.offer(new int[]{rem[0], y, val});
    }
    assert maxHeap.peek() != null;
    return maxHeap.peek()[2];
  }
}
