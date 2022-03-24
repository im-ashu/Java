package com.datastructure.string;

public class RemoveCharacters {

  public static void main(String[] args) {
    String s1 = "occurrence";
    String s2 = "car";
    System.out.println(removeChars(s1, s2));
  }

  static String removeChars(String string1, String string2) {
    // code here
    int[] characters = new int[26];
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < string2.length(); i++) {
      characters[string2.charAt(i) - 'a'] = 1;
    }
    for (int i = 0; i < string1.length(); i++) {
      if (characters[string1.charAt(i) - 'a'] != 1) {
        result.append(string1.charAt(i));
      }
    }
    return result.toString();
  }
}