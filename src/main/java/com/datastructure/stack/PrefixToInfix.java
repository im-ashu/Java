package com.datastructure.stack;

import java.util.Stack;

public class PrefixToInfix {

  public static void main(String[] args) {
    String expression = "*-a/bc-/akl";
    System.out.println(prefixToInfix(expression));
  }

  private static String prefixToInfix(String expression) {
    Stack<String> stack = new Stack<>();
    int length = expression.length();
    for (int i = length - 1; i >= 0; i--) {
      String s = String.valueOf(expression.charAt(i));
      if (isOperator(s)) {
        String operand1 = stack.pop();
        String operand2 = stack.pop();
        stack.push(
            new StringBuilder().append("(").append(operand1).append(s).append(operand2).append(")")
                .toString());
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
