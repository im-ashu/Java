package com.codestudio;

public class RajuAndHisString {

  public static void main(String[] args) {
    int n = 4;
    String s = "bake";
    System.out.println(isGoodString(s, n));
  }

  static boolean isGoodString(String s, int n) {
    // Write your code here.
    char[] occurrences = new char[26];
    int unique = 0;
    for (char ch : s.toCharArray()) {
      occurrences[ch - 'a']++;
      if (occurrences[ch - 'a'] == 1) {
        unique++;
      }
    }
    return (unique % 2) == (n % 2);
  }
}
