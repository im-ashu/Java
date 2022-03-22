package com.datastructure.sort;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] arr = {5, 7, 8, 4, 1, 5, 4, 2, 6};
    mergeSort(arr, 0, arr.length - 1);
    Arrays.stream(arr).mapToObj(e -> e + " ").forEach(System.out::print);
  }

  private static void mergeSort(int[] arr, int low, int high) {
    if (low < high) {
      int mid = low + ((high - low) >> 1);
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }

  private static void merge(int[] arr, int low, int mid, int high) {
    int N1 = mid + 1 - low;
    int N2 = high - mid;
    int[] a = new int[N1];
    int[] b = new int[N2];
    System.arraycopy(arr, low, a, 0, N1);
    System.arraycopy(arr, mid + 1, b, 0, N2);
    int k = low;
    int i = 0, j = 0;
    while (i < N1 && j < N2) {
      if (a[i] < b[j]) {
        arr[k] = a[i];
        i++;
      } else {
        arr[k] = b[j];
        j++;
      }
      k++;
    }
    while (i < N1) {
      arr[k] = a[i];
      i++;
      k++;
    }
    while (j < N2) {
      arr[k] = b[j];
      j++;
      k++;
    }
  }
}
