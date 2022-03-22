package com.datastructure.stack;

import java.util.Stack;

public class PostfixToInfix {

  public static void main(String[] args) {
    String expression = "abc/-ak/l-*";
    System.out.println(postfixToInfix(expression));
  }

  private static String postfixToInfix(String expression) {
    Stack<String> stack = new Stack<>();
    int length = expression.length();
    for (int i = 0; i < length; i++) {
      char ch = expression.charAt(i);
      String s = String.valueOf(ch);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(s);
      } else {
        String operand1 = stack.pop();
        String operand2 = stack.pop();
        StringBuilder res = new StringBuilder().append("(").append(operand2).append(s)
            .append(operand1).append(")");
        stack.push(res.toString());
      }
    }
    return stack.pop();
  }

}
