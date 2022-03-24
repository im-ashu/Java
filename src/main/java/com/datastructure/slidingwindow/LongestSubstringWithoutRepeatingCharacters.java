package com.datastructure.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    String s = "pwwkep";
    System.out.println(longestSubstringWithoutRepeatingCharacters(s));
  }

  private static int longestSubstringWithoutRepeatingCharacters(String s) {
    int n = s.length();
    int begin = 0, end = 0;
    HashMap<Character, Integer> hm = new HashMap<>();
    int len = Integer.MIN_VALUE;
    int head = 0;
    while (end < n) {
      final char charAtEnd = s.charAt(end);
      hm.put(charAtEnd, hm.getOrDefault(charAtEnd, 0) + 1);
      if (hm.size() == end - begin + 1) {
        if (len < end - begin + 1) {
          len = end - begin + 1;
          head = begin;
        }
      } else if (hm.size() < end - begin + 1) {
        while (begin < end && hm.size() < end - begin + 1) {
          final char charAt = s.charAt(begin);
          if (hm.containsKey(charAt)) {
            hm.put(charAt, hm.get(charAt) - 1);
            if (hm.get(charAt) == 0) {
              hm.remove(charAt);
            }
          }
          begin++;
        }
      }
      end++;
    }
    String ans = s.substring(head, head + len);
    System.out.println(ans);
    return len;
  }

}