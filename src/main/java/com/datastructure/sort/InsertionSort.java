package com.datastructure.sort;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = {5, 7, 8, 4, 1, 5, 4, 2, 6};
    insertionSort(arr);
    Arrays.stream(arr).mapToObj(e -> e + " ").forEach(System.out::print);
  }

  private static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      insert(arr, i, arr[i]);
    }
  }

  private static void insert(int[] arr, int pos, int val) {
    int i = pos - 1;
    while (i >= 0 && arr[i] > val) {
      arr[i + 1] = arr[i];
      i--;
    }
    arr[i + 1] = val;
  }
}
