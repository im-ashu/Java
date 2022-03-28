package com.leetcode;

import java.util.HashMap;

public class ValidAnagram {

  public static void main(String[] args) {
    ValidAnagram v = new ValidAnagram();
    String s = "rat";
    String t = "car";
    System.out.println(v.isAnagram(s, t));
    System.out.println(v.isAnagramII(s, t));

  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int distinctChar = 0;
    int[] countArr = new int[26];

    for (char ch : s.toCharArray()) {
      if (countArr[ch - 'a'] == 0) {
        distinctChar++;
      }
      countArr[ch - 'a']++;
    }

    for (char ch : t.toCharArray()) {
      countArr[ch - 'a']--;
      if (countArr[ch - 'a'] == 0) {
        distinctChar--;
      }
    }
    return distinctChar == 0;
  }

  public boolean isAnagramII(String s, String t) {
    int n = s.length();
    int m = t.length();
    if (n != m) {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      map.put(ch, 1 + map.getOrDefault(ch, 0));
    }
    int counter = map.size();
    for (int i = 0; i < m; i++) {
      char ch = t.charAt(i);
      if (map.containsKey(ch) && map.get(ch) > 0) {
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 0) {
          counter--;
        }
      } else {
        return false;
      }
    }
    return counter == 0;
  }
}