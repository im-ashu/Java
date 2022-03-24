package com.datastructure.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    String s = "EBANBBC";
    String t = "ABC";
    System.out.println(minWindow(s, t));
  }

  public static String minWindow(String s, String t) {
    HashMap<Character, Integer> hm = new HashMap<>();
    int begin = 0, end = 0, head = 0;
    int len = Integer.MAX_VALUE;
    int counter;
    for (int i = 0; i < t.length(); i++) {
      final char c = t.charAt(i);
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    }
    counter = hm.size();
    int n = s.length();
    while (end < n) {
      final char charAtEnd = s.charAt(end);
      if (hm.containsKey(charAtEnd)) {
        hm.put(charAtEnd, hm.get(charAtEnd) - 1);
        if (hm.get(charAtEnd) == 0) {
          counter--;
        }
      }
      while (counter == 0) {
        if (len > end - begin + 1) {
          len = end - begin + 1;
          head = begin;
        }

        final char charAtBegin = s.charAt(begin);
        if (hm.containsKey(charAtBegin)) {
          hm.put(charAtBegin, hm.get(charAtBegin) + 1);
          if (hm.get(charAtBegin) == 1) {
            counter++;
          }
        }
        begin++;
      }
      end++;
    }
   if (len == Integer.MAX_VALUE) {
    return "";
   }
    return s.substring(head, head + len);
  }
}