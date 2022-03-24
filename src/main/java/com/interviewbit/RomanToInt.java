package com.interviewbit;

import java.util.HashMap;

public class RomanToInt {

  public static void main(String[] args) {
    String A = "VI";
    System.out.println(romanToInt(A));
  }

  public static int romanToInt(String A) {
    int n = A.length();
    if (n == 0) {
      return 0;
    }
    HashMap<Character, Integer> hm = new HashMap<>();
    hm.put('I', 1);
    hm.put('V', 5);
    hm.put('X', 10);
    hm.put('L', 50);
    hm.put('C', 100);
    hm.put('D', 500);
    hm.put('M', 1000);
    if (n == 1) {
      return hm.get(A.charAt(0));
    }
    int sum = hm.get(A.charAt(n - 1));
    for (int i = n - 2; i >= 0; i--) {
      if (hm.get(A.charAt(i)) < hm.get(A.charAt(i + 1))) {
        sum -= hm.get(A.charAt(i));
      } else {
        sum += hm.get(A.charAt(i));
      }
    }
    return sum;
  }
}