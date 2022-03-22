package com.hackerrank.queue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MinMaxRiddle {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the riddle function below.
  static long[] riddle(long[] arr) {
    // complete this function
    int n = arr.length;
    long[] result = new long[n];
    result[0] = Arrays.stream(arr).max().getAsLong();
    for (int i = 2; i <= n; i++) {
      Deque<Integer> deque = new LinkedList<>();
      int j;
      long max = Integer.MIN_VALUE;
      for (j = 0; j < i; j++) {
        while (!deque.isEmpty() && arr[j] <= arr[deque.peekLast()]) {
          deque.removeLast();
        }
        deque.addLast(j);
      }
      for (; j < n; j++) {
        if (max < arr[deque.peekFirst()]) {
          max = arr[deque.peekFirst()];
        }
        while (!deque.isEmpty() && deque.peekFirst() <= j - i) {
          deque.removeFirst();
        }
        while (!deque.isEmpty() && arr[j] <= arr[deque.peekLast()]) {
          deque.removeLast();
        }
        deque.addLast(j);
      }
      if (max < arr[deque.peekFirst()]) {
        max = arr[deque.peekFirst()];
      }
      result[i - 1] = max;
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("MinMaxRiddle.txt"));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    long[] arr = new long[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      long arrItem = Long.parseLong(arrItems[i]);
      arr[i] = arrItem;
    }

    long[] res = riddle(arr);

    for (int i = 0; i < res.length; i++) {
      bufferedWriter.write(String.valueOf(res[i]));

      if (i != res.length - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
