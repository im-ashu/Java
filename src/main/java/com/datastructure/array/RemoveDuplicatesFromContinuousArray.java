package com.datastructure.array;

import java.util.Arrays;

public class RemoveDuplicatesFromContinuousArray {

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 7};
    int n = array.length;
    int j = 0;
    for (int i = 1; i < n; i++) {
      if (array[i] != array[i - 1]) {
        array[j] = array[i];
        j++;
      }
    }
    array = Arrays.copyOf(array, j);
    Arrays.stream(array).forEach(e -> System.out.print(e + " "));
  }
}