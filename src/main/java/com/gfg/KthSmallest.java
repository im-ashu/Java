package com.gfg;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

  public static void main(String[] args) {
    PrintWriter out = new PrintWriter(System.out);
    int t = 1;

    while (t-- > 0) {

      int arr[] = {7, 10, 4, 20, 15};
      int n = arr.length;
      int k = 4;
      KthSmallest ob = new KthSmallest();
      out.println(ob.kthSmallest(arr, 0, n, k));
    }
    out.flush();
  }

  public static int kthSmallest(int[] arr, int l, int r, int k) {
    //Your code here
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < arr.length; i++) {
      maxHeap.add(arr[i]);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    return maxHeap.peek();
  }
}