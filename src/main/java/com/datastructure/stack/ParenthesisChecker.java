package com.datastructure.stack;

import java.util.Stack;

public class ParenthesisChecker {

  public static void main(String[] args) {
    System.out.println(isPar("{([[[[[[[[[["));
    System.out.println(solve("()"));
  }

  static boolean isPar(String x) {
    // add your code here
    Stack<Character> stack = new Stack<>();
    int n = x.length();
    for (int i = 0; i < n; i++) {
      char c = x.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        Character openingParenthesis = stack.pop();
        if (c == ')' && openingParenthesis != '(') {
          return false;
        }
        if (c == ']' && openingParenthesis != '[') {
          return false;
        }
        if (c == '}' && openingParenthesis != '{') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static int solve(String A) {
    Stack<Character> s = new Stack<>();
    int N = A.length();
    for (int i = 0; i < N; i++) {
      if (A.charAt(i) == '(') {
        s.push('(');
      } else {
        if (!s.isEmpty()) {
          s.pop();
        } else {
          return 0;
        }
      }
    }
    return s.isEmpty() ? 1 : 0;
  }
}