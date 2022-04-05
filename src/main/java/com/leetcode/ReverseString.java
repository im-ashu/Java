package com.leetcode;

public class ReverseString {

  public static void main(String[] args) {
    ReverseString reverseString = new ReverseString();
    char[] s = {'h', 'e', 'l', 'l', 'o'};
    reverseString.reverseString(s);
    for (char ch : s) {
      System.out.print(ch + " ");
    }

  }

  public void reverseString(char[] s) {
    if (s.length <= 1) {
      return;
    }
    int i = 0;
    int j = s.length - 1;
    while (i < j) {
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
      i++;
      j--;
    }
  }
}
