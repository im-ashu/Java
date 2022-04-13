package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

  public static void main(String[] args) {
    PermutationInString permutationInString = new PermutationInString();
    String s1 = "abcdxabcde";
    String s2 = "abcdeabcdx";
    System.out.println(permutationInString.checkInclusion(s1, s2));
  }

  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> freqMapS1 = new HashMap<>();
    for (char c : s1.toCharArray()) {
      freqMapS1.put(c, freqMapS1.getOrDefault(c, 0) + 1);
    }
    int counter = freqMapS1.size();
    int end = 0;
    int begin = 0;
    int n = s2.length();
    while (end < n) {
      char eChar = s2.charAt(end);
      if (freqMapS1.containsKey(eChar)) {
        freqMapS1.put(eChar, freqMapS1.get(eChar) - 1);
        if (freqMapS1.get(eChar) == 0) {
          counter--;
        }
      }
      while (end - begin + 1 > s1.length()) {
        char bChar = s2.charAt(begin);
        if (freqMapS1.containsKey(bChar)) {
          freqMapS1.put(bChar, freqMapS1.get(bChar) + 1);
          if (freqMapS1.get(bChar) == 1) {
            counter++;
          }
        }
        begin++;
      }
      if (counter == 0 && end - begin + 1 == s1.length()) {
        return true;
      }
      end++;
    }
    return false;
  }
}
