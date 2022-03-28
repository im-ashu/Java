package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> lists = new GroupAnagrams().groupAnagrams(strs);
    for (List<String> list : lists) {
      for (String s : list) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] c = new char[26];
      str.chars().forEach(ch -> c[ch - 'a']++);
      String s = new String(c);
        if (!map.containsKey(s)) {
            map.put(s, new ArrayList<>());
        }
      map.get(s).add(str);
    }
    return new ArrayList<>(map.values());
  }
}