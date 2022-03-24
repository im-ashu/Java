package com.datastructure.stack;

import java.util.ArrayList;
import java.util.Stack;

public class MaxAreaOfHistogram {

  public static void main(String[] args) {
    int[] arr = {6, 2, 5, 5, 5, 1, 6};
    int n = arr.length;
    System.out.println(maxAreaOfHistogram(arr, n));
  }

  private static int maxAreaOfHistogram(int[] arr, int n) {
    ArrayList<Integer> nsrIndex = findNSRIndex(arr, n);
    ArrayList<Integer> nslIndex = findNSLIndex(arr, n);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int area;
      area = ((nsrIndex.get(i) - nslIndex.get(i) - 1) * arr[i]);
      if (max < area) {
        max = area;
      }
    }
    return max;
  }

  private static ArrayList<Integer> findNSLIndex(int[] arr, int n) {
    Stack<Integer> stackNSL = new Stack<>();
    ArrayList<Integer> nslIndex = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      while (!stackNSL.isEmpty() && arr[stackNSL.peek()] >= arr[i]) {
        stackNSL.pop();
      }
      nslIndex.add(stackNSL.isEmpty() ? -1 : stackNSL.peek());
      stackNSL.add(i);
    }
    return nslIndex;
  }

  private static ArrayList<Integer> findNSRIndex(int[] arr, int n) {
    Stack<Integer> stackNSR = new Stack<>();
    ArrayList<Integer> nsrIndex = new ArrayList<>();

    for (int i = n - 1; i >= 0; i--) {
      while (!stackNSR.isEmpty() && arr[stackNSR.peek()] >= arr[i]) {
        stackNSR.pop();
      }
      nsrIndex.add(stackNSR.isEmpty() ? n : stackNSR.peek());
      stackNSR.add(i);
    }
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      int temp = nsrIndex.get(i);
      nsrIndex.set(i, nsrIndex.get(j));
      nsrIndex.set(j, temp);
    }
    return nsrIndex;
  }
}