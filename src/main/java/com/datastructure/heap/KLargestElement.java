package com.datastructure.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElement {

  public static void main(String[] args) {
    int[] array = {12, 3, 5, 7, 19};
// array = new int[]{12, 13, 12, 13, 11};
    int n = array.length;
    int k = 3;
    ArrayList<Integer> kLargest = kLargest(array, n, k);
    kLargest.forEach(System.out::println);
  }

  //Function to return k largest elements from an array.
  public static ArrayList<Integer> kLargest(int[] arr, int n, int k) {

    PriorityQueue<Integer> elements = new PriorityQueue<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      elements.add(arr[i]);
    }
    for (int i = k; i < n; i++) {
      if (elements.peek() < arr[i]) {
        elements.poll();
        elements.add(arr[i]);
      }
    }
    for (int i = 0; i < k; i++) {
      result.add(elements.poll());
    }
    for (int i = 0, j = k - 1; i < j; i++, j--) {
      int temp = result.get(i);
      result.set(i, result.get(j));
      result.set(j, temp);
    }
    return result;

  }
}