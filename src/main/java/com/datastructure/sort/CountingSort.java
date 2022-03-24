package com.datastructure.sort;

public class CountingSort {

  public static void main(String[] args) {
    System.out.println(countSort("geeksforgeeks"));
  }

  public static String countSort(String arr) {
    // code here
    int[] count = new int[26];
    int n = arr.length();
    for (int i = 0; i < n; i++) {
      count[arr.charAt(i) - 'a']++;
    }
    for (int i = 1; i < count.length; i++) {
      count[i] = count[i] + count[i - 1];
    }
    String result;
    char[] b = new char[n];
    for (int i = n - 1; i >= 0; i--) {
      b[--count[arr.charAt(i) - 'a']] = arr.charAt(i);
    }
    result = new String(b);
    return result;
  }
}