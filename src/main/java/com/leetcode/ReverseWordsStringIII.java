package com.leetcode;

public class ReverseWordsStringIII {

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    System.out.println(new ReverseWordsStringIII().reverseWords(s));
  }

  public String reverseWords(String s) {
    String[] strings = s.split(" ");
    StringBuilder res = new StringBuilder();
    for (String str : strings) {
      res.append(new StringBuilder(str).reverse()).append(" ");
    }
    String result = res.toString();
    return result.substring(0, result.length() - 1);
  }

}