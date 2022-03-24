package com.datastructure.array;

import java.util.Arrays;

public class LeftRotateByDElements {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    rotateArr(arr, 2, arr.length);
    Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
  }

 /*private static void leftRotate(int[] arr, int d, int n)
 {
 d = d % n;
 int gcd = greatestCommonDivisor(d, n);
 int k = -1;
 int j;
 for (int i = 0; i < gcd; i++)
 {
 int temp = arr[i];
 j = i;
 while (true)
 {
 k = j + d;
 if (k >= n)
 {
 k -= n;
 }
 if (k == i)
 break;
 arr[j] = arr[k];
 j = k;
 }
 arr[j] = temp;
 }
 }

 private static int greatestCommonDivisor(int a, int b)
 {
 if (b == 0)
 {
 return a;
 }
 else
 {
 return greatestCommonDivisor(b, a % b);
 }
 }*/

  static void rotateArr(int[] arr, int d, int n) {
    // add your code here
    d = d % n;
    int gcd = gcd(d, n);
    for (int i = 0; i < gcd; i++) {
      int j = i;
      int temp = arr[i];
      while (true) {
        int k = j + d;
        if (k >= n) {
          k = k - n;
        }
        if (k == i) {
          break;
        }
        arr[j] = arr[k];
        j = k;
      }
      arr[j] = temp;
    }
  }

  static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

}