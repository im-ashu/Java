package com.codestudio;

public class RemoveAllOccurrencesOfChar {

  public static void main(String[] args) {
    String input = "";
    char c = 'd';
    String ans = removeAllOccurrencesOfChar(input, c);
    System.out.println(ans);
  }

  static String removeAllOccurrencesOfChar(String input, char c) {
    // Write your code here
    char[] chars = input.toCharArray();
    int index = 0;
    int n = input.length();
    for (int i = 0; i < n; i++) {
      if (chars[i] != c) {
        chars[index] = chars[i];
        index++;
      }
    }
    return new String(chars).substring(0, index);
  }
}
