package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 4, 11, 12));
    int B = 2;
    final ArrayList<Integer> solve = solve(A, B);
    for (Integer integer : solve) {
      System.out.print(integer + " ");
    }

  }

  public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
    ArrayList<Integer> ans = new ArrayList<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int n = A.size();
    for (int i = 0; i < B; i++) {
      minHeap.add(A.get(i));
    }
    for (int i = B; i < n; i++) {
      if (minHeap.peek() < A.get(i)) {
        minHeap.poll();
        minHeap.add(A.get(i));
      }
    }
    while (!minHeap.isEmpty()) {
      ans.add(minHeap.poll());
    }
    return ans;
  }
}