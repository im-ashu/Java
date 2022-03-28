package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {

  public static void main(String[] args) {
    String s = "the sky is blue";
    System.out.println(new ReverseWords().reverseWords(s));
  }

  public String reverseWords(String s) {
    String[] words = s.split(" ");
    List<String> wordsWithoutSpace = Arrays.stream(words).filter(word -> !word.equalsIgnoreCase(""))
        .collect(Collectors.toList());
    Collections.reverse(wordsWithoutSpace);
    StringBuilder sb = new StringBuilder();
    wordsWithoutSpace.forEach(w -> sb.append(w).append(" "));
    return sb.substring(0, s.length());
  }
}