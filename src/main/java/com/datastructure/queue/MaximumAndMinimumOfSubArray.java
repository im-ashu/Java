package com.datastructure.queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumAndMinimumOfSubArray {

  public static void main(String[] args) {
    int[] arr = {2, 5, -1, 7, -3, -1, -2};
    int k = 3;
    System.out.println(SumOfKSubArray(arr, k));
  }

  private static int SumOfKSubArray(int[] arr, int k) {

    Deque<Integer> maxElementIndexes = new LinkedList<>();
    Deque<Integer> minElementIndexes = new LinkedList<>();

    int i;
    for (i = 0; i < k; i++) {
      while (!maxElementIndexes.isEmpty() && arr[i] >= arr[maxElementIndexes.peekLast()]) {
        maxElementIndexes.removeLast();
      }
      while (!minElementIndexes.isEmpty() && arr[i] <= arr[minElementIndexes.peekLast()]) {
        minElementIndexes.removeLast();
      }
      minElementIndexes.addLast(i);
      maxElementIndexes.addLast(i);
    }
    int sum = 0;
    for (; i < arr.length; i++) {
      sum += arr[maxElementIndexes.peekFirst()] + arr[minElementIndexes.peekFirst()];
      while (!maxElementIndexes.isEmpty() && (maxElementIndexes.peekFirst() <= (i - k))) {
        maxElementIndexes.removeFirst();
      }
      while (!minElementIndexes.isEmpty() && minElementIndexes.peekFirst() <= i - k) {
        minElementIndexes.removeFirst();
      }
      while (!maxElementIndexes.isEmpty() && arr[i] >= arr[maxElementIndexes.peekLast()]) {
        maxElementIndexes.removeLast();
      }
      while (!minElementIndexes.isEmpty() && arr[i] <= arr[minElementIndexes.peekLast()]) {
        minElementIndexes.removeLast();
      }
      maxElementIndexes.addLast(i);
      minElementIndexes.addLast(i);
    }
    sum += arr[maxElementIndexes.peekFirst()] + arr[minElementIndexes.peekFirst()];
    return sum;
  }

}
