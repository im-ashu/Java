package com.datastructure.sort;

import java.util.Arrays;

public class HeapSort {

  public static void main(String[] args) {
    int[] arr = {5, 7, 8, 4, 1, 5, 4, 2, 6};
    heapsort(arr);
    Arrays.stream(arr).mapToObj(e -> e + " ").forEach(System.out::print);
  }

  private static void heapsort(int[] arr) {
    int n = arr.length;
    int i = (n >> 1);
    while (i >= 0) {
      heapify(arr, i, n);
      i--;
    }

    for (int j = n - 1; j >= 0; j--) {
      swap(arr, j, 0);
      heapify(arr, 0, j);
    }
  }

  private static void heapify(int[] arr, int i, int n) {
    int left = ((i << 1) + 1);
    int right = ((i << 1) + 2);
    int largest = i;
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, largest, n);
    }

  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
