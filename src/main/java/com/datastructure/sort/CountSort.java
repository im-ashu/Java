package com.datastructure.sort;

public class CountSort {

  public static void main(String[] args) {
    int[] array = new int[]{2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};
    int n = array.length;
    int[] count = new int[n];
    int[] tempArray = new int[n];

    for (int j : array) {
      ++count[j];
    }
    for (int i = 1; i < n; i++) {
      count[i] += count[i - 1];
    }
    for (int i = n - 1; i >= 0; i--) {
      tempArray[--count[array[i]]] = array[i];
    }
    for (int i : tempArray) {
      System.out.println(i);
    }
  }
}