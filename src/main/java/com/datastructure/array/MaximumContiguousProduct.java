package com.datastructure.array;

import java.util.Arrays;
import java.util.List;

public class MaximumContiguousProduct {

  public static void main(String[] args) {
    Integer[] a = {-2, 8, -1, -5};
    System.out.println("Maximum contiguous product is " +
        maxSubArrayProduct(a));
    System.out.println("Maximum contiguous product is " +
        maxProduct(Arrays.asList(a)));
  }

  public static int maxProduct(final List<Integer> A) {
    final Integer[] objects = (Integer[]) A.toArray();
    int n = A.size();
    int maxEndingHere = A.get(0);
    int minEndingHere = A.get(0);
    int maxProduct = A.get(0);
    for (int i = 1; i < n; i++) {
      int temp = maxEndingHere * A.get(i);
      maxEndingHere = Math.max(Math.max(maxEndingHere * A.get(i), A.get(i)),
          minEndingHere * A.get(i));
      minEndingHere = Math.min(Math.min(minEndingHere * A.get(i), A.get(i)), temp);
      maxProduct = Math.max(maxEndingHere, maxProduct);
    }
    return maxProduct;
  }

  private static int maxSubArrayProduct(Integer[] a) {
    int maxSoFar = a[0];
    int maxEndingHere = a[0];
    int minEndingHere = a[0];

    for (int i = 1; i < a.length; i++) {
      int temp = maxEndingHere * a[i];
      maxEndingHere = Math.max(Math.max(minEndingHere * a[i], a[i]), maxEndingHere * a[i]);
      minEndingHere = Math.min(Math.min(temp, a[i]), minEndingHere * a[i]);
      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
      }
    }
    return maxSoFar;
  }
}