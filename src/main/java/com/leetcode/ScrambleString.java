package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

  public static void main(String[] args) {
    ScrambleString scrambleString = new ScrambleString();
    String s1 = "abcdefghijklmn";
    String s2 = "efghijklmncadb";
    System.out.println(scrambleString.isScramble(s1, s2));

  }

  Map<String, Boolean> map = new HashMap<>();

  public boolean isScramble(String s1, String s2) {
    String key = s1
        + s2;

    if (map.containsKey(key)) {
      return map.get(key);
    }

    if (s1.equals(s2)) {
      map.put(key, true);
      return true;
    }

    int[] letters = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      letters[s1.charAt(i) - 'a']++;
      letters[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (letters[i] != 0) {
        map.put(key, false);
        return false;
      }
    }

    for (int i = 1; i < s1.length(); i++) {
      if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i),
          s2.substring(i))) {
        map.put(key, true);
        return true;
      }

      if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(
          s1.substring(i), s2.substring(0, s1.length() - i))) {
        map.put(key, true);
        return true;
      }
    }

    map.put(key, false);
    return false;
  }

}
