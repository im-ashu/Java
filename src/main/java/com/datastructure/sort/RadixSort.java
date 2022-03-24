package com.datastructure.sort;

import java.util.Arrays;
import java.util.OptionalInt;

public class RadixSort {

  public static void main(String[] args) {
    int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = arr.length;

    radixSort(arr, n);
    Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
  }

  private static void radixSort(int[] arr, int n) {
    OptionalInt m = Arrays.stream(arr).max();
    if (m.isPresent()) {
      int max = m.getAsInt();
      int exp = 1;
      while (max / exp > 0) {
        countSort(arr, exp, n);
        exp *= 10;
      }
    }
  }

  private static void countSort(int[] arr, int exp, int n) {
    int[] output = new int[n];
    int[] count = new int[10];
    for (int i = 0; i < n; i++) {
      count[(arr[i] / exp) % 10]++;
    }
    for (int i = 0; i < 9; i++) {
      count[i + 1] += count[i];
    }
    for (int i = n - 1; i >= 0; i--) {
      output[--count[(arr[i] / exp) % 10]] = arr[i];
    }
    System.arraycopy(output, 0, arr, 0, n);
  }
}