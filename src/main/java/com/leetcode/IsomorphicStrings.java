package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  public static void main(String[] args) {
    String s = "paper";
    String t = "title";
    System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
    System.out.println(new IsomorphicStrings().isIsomorphicII(s, t));
  }

  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if (!map.containsKey(c1) && map.containsValue(c2)) {
        return false;
      }
      if (map.containsKey(c1) && map.get(c1) != c2) {
        return false;
      }
      map.put(c1, c2);
    }
    return true;
  }

  public boolean isIsomorphicII(String s, String t) {
    return transform(s).equalsIgnoreCase(transform(t));
  }

  public String transform(String str) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder s = new StringBuilder();
    int n = str.length();
    for (int i = 0; i < n; i++) {
      char c = str.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, i);
      }
      s.append(map.get(c)).append(" ");
    }
    return s.toString();
  }
}