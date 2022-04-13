package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

  public static void main(String[] args) {
    LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
    String s = "a1b2";
    List<String> result = letterCasePermutation.letterCasePermutation(s);
    for (String str : result) {
      System.out.print(str + " ");
    }

  }

  public List<String> letterCasePermutation(String s) {
    s = s.toLowerCase();
    List<String> result = new ArrayList<>();
    letterCasePermutationUtil(s, "", result);
    return result;
  }

  private void letterCasePermutationUtil(String s, String output, List<String> result) {
    if (s.isEmpty()) {
      result.add(output);
      return;
    }
    char ch = s.charAt(0);
    letterCasePermutationUtil(s.substring(1), output + ch, result);
    if (isAlpha(ch)) {
      letterCasePermutationUtil(s.substring(1), output + (Character.toUpperCase(ch)), result);
    }
  }

  private boolean isAlpha(char ch) {
    return ch >= 'a' && ch <= 'z';
  }
}
