package com.datastructure.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {

  public static void main(String[] args) {
    System.out.println(nonrepeatingCharacter("lehlo"));
  }

  static char nonrepeatingCharacter(String S) {
    //Your code here
    Map<Character, Integer> result = new LinkedHashMap<>();
    int n = S.length();
    for (int i = 0; i < n; i++) {
      char ch = S.charAt(i);
      result.put(ch, result.getOrDefault(ch, 0) + 1);
    }
    for (Character character : result.keySet()) {
      if (result.get(character) == 1) {
        return character;
      }
    }
    return '$';
  }

}