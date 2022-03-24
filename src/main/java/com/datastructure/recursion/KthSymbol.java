package com.datastructure.recursion;

public class KthSymbol {

  public static void main(String[] args) {
    int n = 4, k = 8;
    System.out.println(kthSymbol(n, k));
  }

  private static int kthSymbol(int n, int k) {
    if (n == 1 || k == 1) {
      return 0;
    }
    int mid = (int) (Math.pow(2, n - 1)) >> 1;
    if (k <= mid) {
      return kthSymbol(n - 1, k);
    } else {
      return (kthSymbol(n - 1, k - mid) ^ 1);
    }
  }
}