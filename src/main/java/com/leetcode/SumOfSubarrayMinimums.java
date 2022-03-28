package com.leetcode;

import java.util.ArrayDeque;

public class SumOfSubarrayMinimums {

  public static void main(String[] args) {
    int[] arr = {11, 81, 94, 43, 3};
    System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(arr));
    System.out.println(new SumOfSubarrayMinimums().sumSubarrayMinsII(arr));
  }

  public int sumSubarrayMins(int[] arr) {
    int k = 1;
    long sum = 0;
    int n = arr.length;
    int m = (int) (Math.pow(10, 9) + 7);
    while (k <= n) {
      int end = 0;
      int begin = 0;
      ArrayDeque<Integer> q = new ArrayDeque<>();
      while (end < n) {
        while (!q.isEmpty() && q.peekLast() > arr[end]) {
          q.pollLast();
        }
        q.addLast(arr[end]);
        if (end - begin + 1 == k) {
          sum += q.peekFirst();
        }
        while (end - begin + 1 > k) {
          if (arr[begin] == q.peekFirst()) {
            q.pollFirst();
          }
          begin++;
          if (end - begin + 1 == k) {
            sum += q.peekFirst();
          }
        }
        end++;
      }
      k++;
    }
    return (int) (sum % m);
  }

  public int sumSubarrayMinsII(int[] arr) {
    long sum = 0;
    int n = arr.length;
    int m = (int) (Math.pow(10, 9) + 7);
    for (int i = 0; i < n; i++) {
      ArrayDeque<Integer> q = new ArrayDeque<>();
      for (int j = i; j < n; j++) {
        while (!q.isEmpty() && q.peekLast() > arr[j]) {
          q.pollLast();
        }
        q.addLast(arr[j]);
        sum += q.peekFirst();
      }
    }
    return (int) (sum % m);
  }
}