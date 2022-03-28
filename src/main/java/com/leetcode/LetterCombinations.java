package com.leetcode;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

  public static Map<Character, char[]> map = new HashMap<>();

  {
    map.put('2', new char[]{'a', 'b', 'c'});
    map.put('3', new char[]{'d', 'e', 'f'});
    map.put('4', new char[]{'g', 'h', 'i'});
    map.put('5', new char[]{'j', 'k', 'l'});
    map.put('6', new char[]{'m', 'n', 'o'});
    map.put('7', new char[]{'p', 'q', 'r', 's'});
    map.put('8', new char[]{'t', 'u', 'v'});
    map.put('9', new char[]{'w', 'x', 'y', 'z'});
  }

  public static void main(String[] args) {
    String digits = "23";
    List<String> res = new LetterCombinations().letterCombinations(digits);
    for (String s : res) {
      System.out.print(s + " ");
    }
    System.out.println();
    Instant now = Instant.now();
    res = new LetterCombinations().letterCombinationsII(digits);
    for (String s : res) {
      System.out.print(s + " ");
    }
    System.out.println(Duration.between(now, Instant.now()).toMillis());
  }

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    String output = "";
    permute(digits, output, res);
    return res;
  }

  private void permute(String digits, String output, List<String> res) {
    if (digits.isEmpty()) {
      res.add(output);
      return;
    }
    char c = digits.charAt(0);
    for (char ch : map.get(c)) {
      String o = output + ch;
      permute(digits.substring(1), o, res);
    }
  }

  public List<String> letterCombinationsII(String digits) {
    List<String> res = new LinkedList<>();
    if (digits.isEmpty()) {
      return res;
    }
    String[] mappings = new String[]{"abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"};
    res.add("");
    int n = digits.length();
    for (int i = 0; i < n; i++) {
      int size = res.size();
      for (int j = 0; j < size; j++) {
        String s = res.remove(0);
        for (char ch : mappings[digits.charAt(i) - '2'].toCharArray()) {
          res.add(s + ch);
        }

      }
    }
    return res;
  }
}