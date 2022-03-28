package com.bitmanipulation;

public class RepeatedElement {

  public static void main(String[] args) {
    // int[] arr = { 1, 2, 5, 4, 6, 8, 9, 2, 1, 4, 5, 8, 9 };
    int[] arr = {1, 1, 1};
    int v = 0;
    for (int j : arr) {
      v = v ^ j;
    }
    System.out.println(v);
  }
}