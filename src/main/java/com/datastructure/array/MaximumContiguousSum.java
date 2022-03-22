package com.datastructure.array;

public class MaximumContiguousSum {

  public static void main(String[] args) {
    int[] a = {17, -30, 4, -1, -2, 1, 5, -3};
    System.out.println("Maximum contiguous sum is " +
        maxSubArraySum(a));
  }

  /**
   * Kadane Algorithm
   */
  private static int maxSubArraySum(int[] a) {
    int maxSoFar = a[0];
    int maxEndingHere = a[0];
    int n = a.length;
    int start = 0, s = 0;
    int end = 0;
    for (int i = 1; i < n; i++) {
      maxEndingHere += a[i];
      if ((maxEndingHere < a[i])) {
        maxEndingHere = a[i];
        s = i;
      }
      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
        start = s;
        end = i;
      }
    }
    System.out.println("Starting element " + a[start]);
    System.out.println("Ending element " + a[end]);
    return maxSoFar;
  }
}