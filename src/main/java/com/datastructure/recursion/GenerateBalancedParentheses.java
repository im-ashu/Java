package com.datastructure.recursion;

import java.text.MessageFormat;
import java.util.ArrayList;

public class GenerateBalancedParentheses {

  public static void main(String[] args) {
    int n = 3;
    ArrayList<String> ans = new ArrayList<>();
    String op = "";
    generateParentheses(n, n, op, ans);
    ans.forEach(e -> System.out.print(MessageFormat.format("'{'{0}'}' ", e)));
  }

  private static void generateParentheses(int open, int close, String op, ArrayList<String> ans) {
    if (open == 0 && close == 0) {
      ans.add(op);
      return;
    }
    if (open == close) {
      op = op + '(';
      generateParentheses(open - 1, close, op, ans);
    } else {
      if (open > 0) {
        String op1 = op + '(';
        String op2 = op + ')';
        generateParentheses(open - 1, close, op1, ans);
        generateParentheses(open, close - 1, op2, ans);
      } else {
        String op2 = op + ')';
        generateParentheses(open, close - 1, op2, ans);
      }
    }
  }
}