package com.leetcode;

public class CountCharacters {

  public static void main(String[] args) {
    String[] words = {"cat", "bt", "hat", "tree"};
    String chars = "atach";
    System.out.println(new CountCharacters().countCharacters(words, chars));

  }

  public int countCharacters(String[] words, String chars) {
    int[] c = new int[26];
    int ans = 0;
    chars.chars().forEach(ch -> ++c[ch - 'a']);
    for (String word : words) {
      boolean flag = true;
      int[] clone = c.clone();
      for (char ch1 : word.toCharArray()) {
        if (--clone[ch1 - 'a'] < 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        ans += word.length();
      }
    }
    return ans;
  }
}