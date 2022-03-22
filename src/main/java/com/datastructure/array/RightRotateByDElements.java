package com.datastructure.array;

import java.util.Arrays;

public class RightRotateByDElements {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    rightRotate(arr, 2, arr.length);
    Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    System.out.println();
    arr = new int[]{1, 2, 3, 4, 5, 6, 7};
    new RightRotateByDElements().rotate(arr, 2);
    Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
  }

  private static void rightRotate(int[] arr, int d, int n) {
    reverseArray(arr, 0, n - 1);
    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, n - 1);
  }

  private static void reverseArray(int[] arr, int low, int high) {
    while (low < high) {
      int temp = arr[low];
      arr[low] = arr[high];
      arr[high] = temp;
      low++;
      high--;
    }
  }

  public void rotate(int[] arr, int k) {
    if (k == 0) {
      return;
    }
    int n = arr.length;
    k = k % n;
    k = n - k;
    int d = gcd(n, k);
    for (int i = 0; i < d; i++) {
      int temp = arr[i];
      int j = i;
      while (true) {
        int t = j + k;
        if (t >= n) {
          t = t - n;
        }
        if (t == i) {
          break;
        }
        arr[j] = arr[t];
        j = t;
      }
      arr[j] = temp;
    }

  }

  public int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}