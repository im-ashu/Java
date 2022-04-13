package com.codestudio;

public class TwoZeroes {

  public static void main(String[] args) {
    int l = 2;
    int r = 9;
    System.out.println(countInteresting(l, r));
  }

  public static int countInteresting(int l, int r) {
    // Write your code here.
    int count = 0;
    for (int i = 3; i < 31; i++) {
      for (int j = 0; j < i - 1; j++) {
        for (int k = j + 1; k < i - 1; k++) {
          int x = ((1 << i) - 1) ^ (1 << j) ^ (1 << k);
          if (x >= l && x <= r) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
