package com.basic;

public class ReverseBits {

  public static void main(String[] args) {
    long a = 5;
    int max = Integer.MIN_VALUE - 1;
    System.out.println(max);
    System.out.println(reverse(a));
    System.out.println(bitSet(a));
    System.out.println(solve(100000000));
  }

  public static long reverse(long a) {
    int j = 0;
    long rev = 0;
    for (int i = 31; i >= 0; i--) {
      long mask = (long) Math.pow(2, i);
      if ((a & mask) != 0) {
        long sMask = (long) Math.pow(2, j);
        rev = rev | sMask;
      }
      j++;
    }
    return rev;
  }

  public static boolean bitSet(long a) {
    if (a == 0) {
      return false;
    }
    int bitCount = (int) (Math.log(a) / Math.log(2) + 1);
    for (int i = 0; i < bitCount; i++) {
      int mask = 1 << i;
      if ((mask & a) == 0) {
        return false;
      }
    }
    return true;
  }

  public static int solve(int A) {
    if (A == 0) {
      return 0;
    }
    int mod = 1000000007;
    int count = 0;
    while (A > 0) {
      int bitCount = (int) (Math.log(A) / Math.log(2) + 1);
      for (int i = 0; i < bitCount; i++) {
        int mask = 1 << i;
        if ((mask & A) != 0) {
          count = (count % mod) + 1;
        }
      }
      A--;
    }
    return count % mod;
  }

  public static int solveII(int n) {
    int mod = (int) 1e9 + 7;
    long res = 0;
    // Integer.bitCount(num) returns number of set bit in num in constant time
    for (int i = 1; i <= n; i++) {
      res += Integer.bitCount(i);
    }
    return (int) (res % mod);

  }

  public int numSetBits(long a) {
    int counter = 0;
    while (a != 0) {
      a = a & (a - 1);
      counter++;
    }
    return counter;
  }
}