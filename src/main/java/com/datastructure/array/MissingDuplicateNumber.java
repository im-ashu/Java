package com.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MissingDuplicateNumber {

  public static void main(String[] args) {
    Integer[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
    final ArrayList<Integer> r = swapSort(arr);
    r.stream().map(e -> e + " ").forEach(System.out::print);
    System.out.println();
    System.out.println(
        new MissingDuplicateNumber().repeatedNumber(new ArrayList<>(Arrays.asList(arr))));
  }

  private static ArrayList<Integer> swapSort(Integer[] arr) {
    ArrayList<Integer> r = new ArrayList<>();
    int n = arr.length;
    int i = 0;
    while (i < n) {
      final int pos = arr[i] - 1;
      if (!Objects.equals(arr[i], arr[pos])) {
        swap(arr, i, pos);
      } else {
        i++;
      }
    }
    for (int j = 0; j < n; j++) {
      if (arr[j] != j + 1) {
        r.add(arr[j]); // Duplicate
        r.add(j + 1); // Missing
      }
    }
    return r;
  }

  private static void swap(Integer[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public int repeatedNumber(final List<Integer> A) {
    int slow = A.get(0), fast = A.get(A.get(0));
    while (slow != fast) {
      slow = A.get(slow);
      fast = A.get(A.get(fast));
    }
    fast = 0;
    while (slow != fast) {
      slow = A.get(slow);
      fast = A.get(fast);
    }
    return slow;
  }
}