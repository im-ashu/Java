package com.datastructure.string;

public class KMP {

  public static void main(String[] args) {
    String txt = "ABABDABACDABABCABAB";
    String pat = "ABABCABAB";
    new KMP().search(pat, txt);
  }

  private void search(String pat, String txt) {
    int n = txt.length();
    int m = pat.length();
    int[] lps = new int[m];
    computeLPS(pat, lps);
    int i = 0;
    int j = 0;
    while (i < n) {
      if (txt.charAt(i) == pat.charAt(j)) {
        i++;
        j++;
      }
      if (j == m) {
        System.out.println("Pattern found at index " + (i - j));
        j = lps[j - 1];
      } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
  }

  private void computeLPS(String pat, int[] lps) {
    int len = 0;
    int i = 1;
    lps[0] = 0;
    int m = pat.length();
    while (i < m) {
      if (pat.charAt(i) == pat.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = len;
          i++;
        }
      }
    }
  }
}