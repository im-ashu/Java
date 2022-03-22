package com.datastructure.array;

import java.util.ArrayList;
import java.util.List;

public class FindKPairsWithSmallestSums {

  public static void main(String[] args) {
    int[] arr1 = {1, 7, 11};
    int[] arr2 = {2, 4, 6};
    findPairs(arr1, arr2, 3).stream().map(pair -> "[" + pair.first + ", " + pair.second + "]")
        .forEach(System.out::println);
  }

  private static List<Pair> findPairs(int[] arr1, int[] arr2, int k) {
    List<Pair> result = new ArrayList<>();
    int i1 = 0, i2 = 0;
    result.add(new Pair(arr1[0], arr2[0]));
    for (int i = 0; i < k - 1; i++) {
      if ((arr1[i1] + arr2[i2 + 1]) < (arr1[i1 + 1] + arr2[i2])) {
        result.add(new Pair(arr1[i1], arr2[i2 + 1]));
        i2++;
      } else {
        result.add(new Pair(arr1[i1 + 1], arr2[i2]));
        i1++;
      }

    }
    return result;
  }

  static class Pair {

    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}