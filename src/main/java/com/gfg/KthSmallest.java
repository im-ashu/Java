package com.gfg;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

  public static void main(String[] args) {
    PrintWriter out = new PrintWriter(System.out);
    int t = 1;

    while (t-- > 0) {

      int[] arr = {7, 10, 4, 20, 15};
      int k = 4;
      out.println(kthSmallest(arr, k));
    }
    out.flush();
  }

  public static int kthSmallest(int[] arr, int k) {
    //Your code here
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int j : arr) {
      maxHeap.add(j);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    return maxHeap.peek();
  }
}