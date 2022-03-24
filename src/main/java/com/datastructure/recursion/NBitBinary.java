package com.datastructure.recursion;

import java.util.ArrayList;

public class NBitBinary {

  public static void main(String[] args) {
    int n = 3;
    ArrayList<String> ans = new ArrayList<>();
    String op = "";
    nBitBinary(n, 0, 0, op, ans);
    ans.forEach(e -> System.out.print("{" + e + "} "));
  }

  private static void nBitBinary(int n, int count0, int count1, String op, ArrayList<String> ans) {
    if (n == 0) {
      ans.add(op);
      return;
    }
    nBitBinary(n - 1, count0, count1 + 1, op + '1', ans);
    if (count1 > count0) {
      nBitBinary(n - 1, count0 + 1, count1, op + '0', ans);
    }
  }
}