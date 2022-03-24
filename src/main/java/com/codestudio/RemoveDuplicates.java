package com.codestudio;

public class RemoveDuplicates {

  public static void main(String[] args) {
    String str = "zzzzzxx";
    System.out.println(removeDuplicates(str));
  }

  public static String removeDuplicates(String str) {
    //Your code goes here
    char[] chars = str.toCharArray();
    int[] count = new int[26];
    int index = 0;
    for (char c : chars) {
      if (count[c - 'a']++ == 0) {
        chars[index++] = c;
      }
    }
    return new String(chars).substring(0, index);
  }
}
