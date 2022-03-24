package com.datastructure.string;

public class FirstCharacterOfEveryWord {

  public static void main(String[] args) {
    String S = "bad is good";
    System.out.println(firstAlphabet(S));
  }

  public static String firstAlphabet(String S) {
    // code here
    String[] s = S.split(" ");
    StringBuilder result = new StringBuilder();
    for (String value : s) {
      if (value.length() > 0) {
        result.append(value.charAt(0));
      }
    }
    return result.toString();
  }
}