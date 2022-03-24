package com.datastructure.recursion;

import java.util.ArrayList;

public class LetterCasePermutation {

  public static void main(String[] args) {
    String ip = "a1B2";
    ip = ip.toLowerCase();
    String op = "";
    ArrayList<String> res = new ArrayList<>();
    permute(ip, op, res);
    res.forEach(e -> System.out.print("(" + e + ")"));

  }

  private static void permute(String ip, String op, ArrayList<String> res) {
    if (ip.isEmpty()) {
      res.add(op);
      return;
    }
    final char c = ip.charAt(0);
    String op1;
    if (c >= 97 && c <= 123) {
      op1 = op + ((char) (c - 32));
      String op2 = op + c;
      ip = ip.substring(1);
      permute(ip, op1, res);
      permute(ip, op2, res);
    } else {
      op1 = op + c;
      ip = ip.substring(1);
      permute(ip, op1, res);
    }
  }
}