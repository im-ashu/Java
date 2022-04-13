package com.datastructure.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CountAnagramsOccurrences {

  public static void main(String[] args) {
    String text = "abcdxabcde";
    String pattern = "abcdeabcdx";
    System.out.println(countAnagrams(text, pattern));
  }

  private static int countAnagrams(String txt, String pat) {
    int n = txt.length();
    int k = pat.length();
    Map<Character, Integer> hm = new HashMap<>();
    IntStream.range(0, k).forEach(l -> {
      final char c = pat.charAt(l);
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    });
    int distinctCharCount = hm.size();
    int res = 0;
    int i = 0;
    int j = 0;
    while (j < n) {
      final char charAtJ = txt.charAt(j);
      if (hm.containsKey(charAtJ)) {
        hm.put(charAtJ, hm.get(charAtJ) - 1);
        if (hm.get(charAtJ) == 0) {
          distinctCharCount--;
        }
      }
      if (j - i + 1 == k) {
        if (distinctCharCount == 0) {
          res++;
        }
        final char charAtI = txt.charAt(i);
        if (hm.containsKey(charAtI)) {
          hm.put(charAtI, hm.get(charAtI) + 1);
          if (hm.get(charAtI) == 1) {
            distinctCharCount++;
          }
        }
        i++;
      }
      j++;
    }
    return res;
  }
}