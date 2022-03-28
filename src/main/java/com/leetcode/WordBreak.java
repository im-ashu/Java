package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak {

  public static void main(String[] args) {
    String s = "aaaaaa";
    List<String> wordDict = new ArrayList<>(Arrays.asList("aaaa", "aa"));
    System.out.println(new WordBreak().wordBreak(s, wordDict));
    System.out.println(new WordBreak().wordBreakII(s, wordDict));
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    int i = 0;
    int j = s.length();
    HashMap<String, Boolean> map = new HashMap<>();
    return wordBreakUtil(s, wordDict, i, j, map);

  }

  private boolean wordBreakUtil(String s, List<String> wordDict, int i, int j,
      HashMap<String, Boolean> map) {
    if (wordDict.contains(s.substring(i, j))) {
      return true;
    }

    if (map.containsKey(s.substring(i, j))) {
      return map.get(s.substring(i, j));
    }
    for (int k = i; k <= j - 1; k++) {
      if (wordDict.contains(s.substring(i, k))) {
        boolean left;
        if (map.containsKey(s.substring(i, k))) {
          left = map.get(s.substring(i, k));
        } else {
          left = wordBreakUtil(s, wordDict, i, k, map);
          map.put(s.substring(i, k), left);
        }
        boolean right;
        if (map.containsKey(s.substring(k, j))) {
          right = map.get(s.substring(k, j));
        } else {
          right = wordBreakUtil(s, wordDict, k, j, map);
          map.put(s.substring(k, j), right);
        }
        map.put(s.substring(i, j), left && right);
        if (left && right) {
          return true;
        }
      }
    }
    map.put(s.substring(i, j), false);
    return map.get(s.substring(i, j));
  }

  public boolean wordBreakII(String s, List<String> wordDict) {
    int len = s.length();
    boolean[] dp = new boolean[len + 1];
    dp[len] = true;

    for (int i = len - 1; i > -1; i--) {
      for (String word : wordDict) {
        if (i + word.length() <= len && s.startsWith(word, i)) {
          dp[i] = dp[i + word.length()];
        }
          if (dp[i]) {
              break;
          }
      }
    }
    return dp[0];
  }
}