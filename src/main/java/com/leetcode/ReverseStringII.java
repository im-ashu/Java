package com.leetcode;

public class ReverseStringII {

  public static void main(String[] args) {
    ReverseStringII reverseStringII = new ReverseStringII();
    String s = "abcdefgh";
    int k = 3;
    System.out.println(reverseStringII.reverseStr(s, k));

  }

  public String reverseStr(String s, int k) {
    if (s.length() <= 1) {
      return s;
    }
    int n = s.length();
    char[] chars = s.toCharArray();
    int twok = (k << 1);
    for (int a = 0; a < n; a = a + twok) {
      int i = a;
      int j = i + k - 1;
      while (i < j) {
        if (j < n) {
          char temp = chars[i];
          chars[i] = chars[j];
          chars[j] = temp;
          i++;
        }
        j--;
      }
    }
    return new String(chars);
  }
}
