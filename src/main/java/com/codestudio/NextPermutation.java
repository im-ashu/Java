package com.codestudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

  public static void main(String[] args) {
    ArrayList<Integer> permutation = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 5));
    System.out.println(nextPermutation(permutation));
  }

  public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
    // Write your code here.
    int index1 = -1;
    int n = permutation.size();
    if (n == 1) {
      return permutation;
    }
    for (int i = n - 2; i >= 0; i--) {
      if (permutation.get(i) < permutation.get(i + 1)) {
        index1 = i;
        break;
      }
    }
    if (index1 == -1) {
      Collections.reverse(permutation);
      return permutation;
    }
    int index2 = -1;
    for (int i = n - 1; i >= 0; i--) {
      if (permutation.get(i) > permutation.get(index1)) {
        index2 = i;
        break;
      }
    }
    Collections.swap(permutation, index1, index2);
    reverse(permutation, index1 + 1, n - 1);
    return permutation;
  }

  private static void reverse(ArrayList<Integer> permutation, int i, int j) {
    while (i < j) {
      int temp = permutation.get(i);
      permutation.set(i, permutation.get(j));
      permutation.set(j, temp);
      i++;
      j--;
    }
  }
}
