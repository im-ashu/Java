package com.hackerrank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArraysLeftRotation {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {
    int size = a.length;
    d = d % size;
    reverseArray(a, 0, d - 1);
    reverseArray(a, d, size - 1);
    reverseArray(a, 0, size - 1);
    return a;
  }

  private static void reverseArray(int[] a, int start, int end) {
    int temp;
    while (start < end) {
      temp = a[end];
      a[end] = a[start];
      a[start] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ArraysLeftRotation.txt"));

    String[] nd = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nd[0]);

    int d = Integer.parseInt(nd[1]);

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    int[] result = rotLeft(a, d);

    for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(String.valueOf(result[i]));

      if (i != result.length - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
