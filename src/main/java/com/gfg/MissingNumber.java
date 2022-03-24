package com.gfg;// { Driver Code Starts
// Initial Template for Java

import java.io.IOException;
import java.util.Arrays;

public class MissingNumber {

  public static void main(String[] args) throws IOException {

    int t = 1;
    while (t-- > 0) {
      int[] array = {1, 2, 3, 5};
      int n = array.length + 1;
      MissingNumber sln = new MissingNumber();
      System.out.println(sln.MissingNumber(array, n));
    }
  }

  int MissingNumber(int array[], int n) {
    // Your Code Here
    final int sum = Arrays.stream(array).sum();
    final int rangeSum = (n * (n + 1) >> 1);
    return rangeSum - sum;
  }
}