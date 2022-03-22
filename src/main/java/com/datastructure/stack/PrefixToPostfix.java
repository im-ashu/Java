package com.datastructure.stack;

import java.util.Stack;

public class PrefixToPostfix {

  public static void main(String[] args) {
    String expression = "*-a/bc-/akl";
    System.out.println(prefixToPostfix(expression));
  }

  private static String prefixToPostfix(String expression) {
    Stack<String> stack = new Stack<>();
    int length = expression.length();
    for (int i = length - 1; i >= 0; i--) {
      String s = String.valueOf(expression.charAt(i));
      if (isOperator(s)) {
        String operand1 = stack.pop();
        String operand2 = stack.pop();
        String res = new StringBuilder().append(operand1).append(operand2).append(s).toString();
        stack.push(res);
      } else {
        stack.push(s);
      }
    }
    return stack.pop();
  }

  private static boolean isOperator(String ch) {
    switch (ch) {
      case "+":
      case "-":
      case "*":
      case "/":
      case "^":
        return true;
    }
    return false;
  }
}
