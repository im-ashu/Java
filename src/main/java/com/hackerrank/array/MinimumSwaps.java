package com.hackerrank.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumSwaps {

  public static void main(String[] args) {
    int[] arr = {4, 3, 1, 2};
    System.out.println(minimumSwaps(arr));
  }

  static int minimumSwaps(int[] arr) {
    int n = arr.length;
    List<int[]> numberIndex = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      numberIndex.add(new int[]{arr[i], i});
    }
    numberIndex.sort(Comparator.comparingInt(a -> a[0]));
    int swapCount = 0;
    for (int i = 0; i < n; i++) {
      if (i != numberIndex.get(i)[1]) {
        swapCount++;
        swap(i, numberIndex.get(i)[1], numberIndex);
        i--;
      }
    }
    return swapCount;
  }

  private static void swap(int i, int j, List<int[]> numberIndex) {
    int[] temp = numberIndex.get(i);
    numberIndex.set(i, numberIndex.get(j));
    numberIndex.set(j, temp);
  }
}
