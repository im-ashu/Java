package com.datastructure.dynamicprogramming.mcm;

import java.util.HashMap;

public class ScrambledString {

  static HashMap<String, Boolean> mp = new HashMap<>();

  public static void main(String[] args) {
    String a = "coder";
    String b = "oderc";

    if (isScramble(a, b)) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }

  private static boolean isScramble(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    if (a.equalsIgnoreCase(b)) {
      return true;
    }
    int n = a.length();
    String key = a + " " + b;
    if (mp.containsKey(key)) {
      return mp.get(key);
    }
    boolean flag = false;
    for (int i = 1; i < n; i++) {
      if (isScramble(a.substring(0, i), b.substring(0, i)) && isScramble(a.substring(i, n),
          b.substring(i, n))) {
        flag = true;
        break;
      }
      if (isScramble(a.substring(0, i), b.substring(n - i, n)) && isScramble(a.substring(i, n),
          b.substring(0, n - i))) {
        flag = true;
        break;
      }
    }
    mp.put(key, flag);
    return flag;
  }
}