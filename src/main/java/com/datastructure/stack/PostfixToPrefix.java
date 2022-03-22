package com.datastructure.stack;

import java.util.Stack;

public class PostfixToPrefix {

  public static void main(String[] args) {
    String expression = "abc/-ak/l-*";
    System.out.println(postfixToPrefix(expression));
  }

  private static String postfixToPrefix(String expression) {
    Stack<String> stack = new Stack<>();
    int length = expression.length();
    for (int i = 0; i < length; i++) {
      String s = String.valueOf(expression.charAt(i));
      if (isOperator(s)) {
        String operand1 = stack.pop();
        String operand2 = stack.pop();
        StringBuilder res = new StringBuilder().append(s).append(operand2).append(operand1);
        stack.push(res.toString());
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
