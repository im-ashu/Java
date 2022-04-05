package com.leetcode;

public class LengthOfLastWord {

  public static void main(String[] args) {
    LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
    String s = "fly";
    System.out.println(lengthOfLastWord.lengthOfLastWord(s));
  }

  public int lengthOfLastWord(String s) {
    int n = s.length();
    int i = n - 1;
    while (i >= 0 && s.charAt(i) == ' ') {
      i--;
    }
    int length = 0;
    while (i >= 0 && s.charAt(i) != ' ') {
      length++;
      i--;
    }
    return length;
  }
}
