package com.datastructure.array;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class FibonacciNumbers {

  public static void main(String[] args) {
    int n = 16;
    System.out.println(fib(n));
    Instant one = Instant.now();
    int[] t = new int[n + 1];
    Arrays.fill(t, -1);
    System.out.println(fibRec(n, t));
    Instant two = Instant.now();
    System.out.println((Duration.between(one, two)).getNano());
  }

  private static int fib(int n) {
    int[] f = new int[n + 1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }

  private static int fibRec(int n, int[] t) {
    if (n == 0 || n == 1) {
      return n;
    }
    if (t[n] != -1) {
      return t[n];
    }
    System.out.println("Recursive Call " + (n));
    return t[n] = (fibRec(n - 2, t) + fibRec(n - 1, t));
  }
}