package com.datastructure.sort;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {5, 7, 8, 4, 1, 5, 4, 2, 6};
    quicksort(arr, 0, arr.length - 1);
    Arrays.stream(arr).mapToObj(e -> e + " ").forEach(System.out::print);
  }

  private static void quicksort(int[] arr, int low, int high) {
    if (low < high) {
      int partition = partition(arr, low, high);
      quicksort(arr, low, partition - 1);
      quicksort(arr, partition + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = high;
    int i = low;
    for (int j = low; j < high; j++) {
      if (arr[j] < arr[pivot]) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, pivot);
    return i;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
