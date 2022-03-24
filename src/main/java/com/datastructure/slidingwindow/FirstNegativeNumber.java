package com.datastructure.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumber {

  public static void main(String[] args) {
    long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
    int k = 3;
    int n = arr.length;
    final long[] firstNegativeNumbers = firstNegativeNumber(arr, n, k);
    Arrays.stream(firstNegativeNumbers).mapToObj(number -> number + " ").forEach(System.out::print);
  }

  private static long[] firstNegativeNumber(long[] A, int N, int K) {
    int i = 0, j = 0;
    long[] res = new long[N - K + 1];
    int index = 0;
    Queue<Integer> q = new LinkedList<>();
    while (j < N) {
      if (A[j] < 0) {
        q.add(j);
      }
      if (j - i + 1 == K) {
        res[index++] = q.isEmpty() ? 0 : A[q.peek()];
        if (A[i] < 0) {
          q.poll();
        }
        i++;
      }
      j++;
    }
    return res;
  }
}