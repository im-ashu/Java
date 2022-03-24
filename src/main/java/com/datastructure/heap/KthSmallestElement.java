package com.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

  public static void main(String[] args) {
    int[] array = {12, 3, 5, 7, 19, 5};
    //        array = new int[]{12, 13, 12, 13, 11};
    int n = array.length;
    int k = 3;
    KthSmallestElement kthSmallestElement = new KthSmallestElement();
    System.out.println(kthSmallestElement.kThSmallestUsingMinHeap(array, n, k));

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < k; i++) {
      maxHeap.add(array[i]);
    }
    for (int i = k; i < n; i++) {
      if (maxHeap.peek() > array[i]) {
        maxHeap.poll();
        maxHeap.add(array[i]);
      }
    }
    System.out.println(maxHeap.peek());
  }

    /* int kThSmallestUsingMaxHeap(int []array, int n, int k){
        MaxHeap max = new MaxHeap(array, k);
        for (int i = k; i < n; i++) {
            if(array[i] < max.getMax()){
                max.replaceMax(array[i]);
            }
        }
        return max.getMax();
    }*/

  int kThSmallestUsingMinHeap(int[] array, int n, int k) {
    MinHeap minHeap = new MinHeap(array, n);
    for (int i = 0; i < k - 1; i++) {
      minHeap.extractMin();
    }
    return minHeap.getMin();
  }
}