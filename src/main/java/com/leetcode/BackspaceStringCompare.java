package com.leetcode;

public class BackspaceStringCompare {

  public static void main(String[] args) {
    BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
    String s = "ab##", t = "c#d#";
    System.out.println(backspaceStringCompare.backspaceCompare(s, t));
  }

  public boolean backspaceCompare(String s, String t) {
    int m = s.length() - 1;
    int n = t.length() - 1;
    int noOfBackspacesInS = 0;
    int noOfBackspacesInT = 0;
    while (m >= 0 || n >= 0) {
      while (m >= 0) {
        if (s.charAt(m) == '#') {
          m--;
          noOfBackspacesInS++;
        } else if (noOfBackspacesInS > 0) {
          noOfBackspacesInS--;
          m--;
        } else {
          break;
        }
      }
      while (n >= 0) {
        if (t.charAt(n) == '#') {
          n--;
          noOfBackspacesInT++;
        } else if (noOfBackspacesInT > 0) {
          noOfBackspacesInT--;
          n--;
        } else {
          break;
        }
      }
      if (m >= 0 && n >= 0 && s.charAt(m) != t.charAt(n)) {
        return false;
      }
      if ((n >= 0) ^ (m >= 0)) {
        return false;
      }
      m--;
      n--;
    }
    return true;
  }
}

