package com.datastructure.slidingwindow;

import java.util.HashMap;

public class LongestKSubString {

  public static void main(String[] args) {
    String s = "acbbe";
    int k = 7;
    System.out.println(longestkSubstr(s, k));
    System.out.println(longestkSubstrII(s, k));
  }

  public static int longestkSubstr(String s, int k) {
    int begin = 0, end = 0;
    int n = s.length();
    int maxLength = 0;
    HashMap<Character, Integer> hm = new HashMap<>();
    int head = 0;
    while (end < n) {
      final char charAtEnd = s.charAt(end);
      hm.put(charAtEnd, hm.getOrDefault(charAtEnd, 0) + 1);
      if (hm.size() == k) {
        if (maxLength < end - begin + 1) {
          maxLength = end - begin + 1;
          head = begin;
        }
      } else if (hm.size() > k) {
        while (begin < end && hm.size() > k) {
          final char charAtBegin = s.charAt(begin);
          if (hm.containsKey(charAtBegin)) {
            hm.put(charAtBegin, hm.get(charAtBegin) - 1);
            if (hm.get(charAtBegin) == 0) {
              hm.remove(charAtBegin);
            }
          }
          begin++;
          if (hm.size() == k) {
            if (maxLength < end - begin + 1) {
              maxLength = end - begin + 1;
              head = begin;
            }
          }
        }
      }
      end++;
    }

    System.out.println(s.substring(head, head + maxLength));
    return maxLength;
  }

  public static int longestkSubstrII(String s, int k) {
    int begin = 0, end = 0;
    int n = s.length();
    int maxLength = Integer.MIN_VALUE;
    HashMap<Character, Integer> hm = new HashMap<>();
    int head = 0;
    while (end < n) {
      final char charAtEnd = s.charAt(end);
      hm.put(charAtEnd, hm.getOrDefault(charAtEnd, 0) + 1);
      while (begin < end && hm.size() > k) {
        final char charAtBegin = s.charAt(begin);
        if (hm.containsKey(charAtBegin)) {
          hm.put(charAtBegin, hm.get(charAtBegin) - 1);
          if (hm.get(charAtBegin) == 0) {
            hm.remove(charAtBegin);
          }
        }
        begin++;
      }
      if (maxLength < end - begin + 1) {
        maxLength = end - begin + 1;
        head = begin;
      }
      end++;
    }

    System.out.println(s.substring(head, head + maxLength));
    return maxLength;
  }

}