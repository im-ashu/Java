package com.leetcode;

public class DecodeWays {

  public static void main(String[] args) {
    String s = "10";
    System.out.println(new DecodeWays().numDecodings(s));
  }

  public int numDecodings(String s) {
    int n = s.length();
    int[] t = new int[n];
    if (s.charAt(0) == '0') {
      return 0;
    }
    t[0] = 1;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
        t[i] = 0;
        return 0;
      } else if (s.charAt(i) != '0' && s.charAt(i - 1) == '0') {
        t[i] = t[i - 1];
      } else if (s.charAt(i) == '0' && s.charAt(i - 1) != '0') {
        if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
          t[i] = (i - 2 >= 0) ? t[i - 2] : 1;
        } else {
          t[i] = 0;
          return 0;
        }
      } else {
        if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
          t[i] = t[i - 1] + ((i - 2 >= 0) ? t[i - 2] : 1);
        } else {
          t[i] = t[i - 1];
        }
      }
    }
    return t[n - 1];
  }
}
