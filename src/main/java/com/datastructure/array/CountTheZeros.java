package com.datastructure.array;

public class CountTheZeros {

  public static void main(String[] args) {
    int[] Arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
    System.out.println(countZeroes(Arr, Arr.length));
  }

  static int countZeroes(int[] arr, int n) {
    // code here
    int countOnes = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        break;
      }
      countOnes += 1;
    }
    return n - countOnes;
  }
}