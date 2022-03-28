package com.leetcode;

import java.util.PriorityQueue;

public class KWeakestRows {

  public static void main(String[] args) {
    int[][] matrix = {{1, 0, 0, 0},
        {1, 1, 1, 1},
        {1, 0, 0, 0},
        {1, 0, 0, 0}};
    int k = 4;
    int[] weakestRows = new KWeakestRows().kWeakestRows(matrix, k);
    for (int weakestRow : weakestRows) {
      System.out.print(weakestRow + " ");
    }

  }

  public int[] kWeakestRows(int[][] mat, int k) {
    int rows = mat.length;
    int cols = mat[0].length;
    int[] weakest = new int[rows];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (mat[i][j] == 0) {
          break;
        }
        weakest[i] += mat[i][j];
      }
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> {
      if (weakest[i] == weakest[j]) {
        return j - i;
      } else {
        return weakest[j] - weakest[i];
      }
    });

    for (int i = 0; i < rows; i++) {
      maxHeap.add(i);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    int[] ans = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      ans[i] = maxHeap.poll();
    }
    return ans;
  }
}
