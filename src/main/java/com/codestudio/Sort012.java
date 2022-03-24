package com.codestudio;

import java.util.Arrays;

public class Sort012 {

  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 1, 2, 1, 2};
    sort012(arr);
    Arrays.stream(arr).mapToObj(e -> e + " ").forEach(System.out::print);
  }

  public static void sort012(int[] arr) {
    //Write your code here
    int index0 = 0;
    int index1 = 0;
    int index2 = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        arr[index2++] = 2;
        arr[index1++] = 1;
        arr[index0++] = 0;
      } else if (arr[i] == 1) {
        arr[index2++] = 2;
        arr[index1++] = 1;
      } else {
        arr[index2++] = 2;
      }
    }
  }

}
