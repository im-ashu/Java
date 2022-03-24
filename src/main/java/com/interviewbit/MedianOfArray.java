package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {

  public static void main(String[] args) {
    final List<Integer> a = new ArrayList<>(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40));
    final List<Integer> b = new ArrayList<>(Arrays.asList(-20));
    System.out.println(findMedianSortedArrays(a, b));
  }

  public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
    int x = a.size();
    int y = b.size();

    if (x > y) {
      return findMedianSortedArrays(b, a);
    }
    int low = 0;
    int high = x;
    while (low <= high) {
      int partitionX = low + ((high - low) >> 1);
      int partitionY = ((x + y + 1) >> 1) - partitionX;
      int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : a.get(partitionX - 1);
      int minRightX = partitionX == x ? Integer.MAX_VALUE : a.get(partitionX);

      int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : b.get(partitionY - 1);
      int minRightY = partitionY == y ? Integer.MAX_VALUE : b.get(partitionY);

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        if ((x + y) % 2 == 0) {
          return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
        } else {
          return Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) {
        high = partitionX - 1;
      } else {
        low = partitionX + 1;
      }
    }
    return 0;
  }
}