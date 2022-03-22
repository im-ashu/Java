package com.datastructure.stack;

import java.util.Stack;

public class InfixToPostfix {

  public static void main(String[] args) {
    String expression = "((a-(b/c))*((a/k)-l))";
    System.out.println(infixToPostfix(expression));
  }

  private static String infixToPostfix(String expression) {
    StringBuilder postfixExpression = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        postfixExpression.append(ch);
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          postfixExpression.append(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek() != '(') {
          return "Invalid Expression";
        } else {
          stack.pop(); //removing opening parenthesis
        }
      } else {
        while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
          if (stack.peek() == '(') {
            return "Invalid Expression";
          }
          postfixExpression.append(stack.pop());
        }
        stack.push(ch);
      }
    }
    while (!stack.isEmpty()) {
      if (stack.peek() == '(') {
        return "Invalid Expression";
      }
      postfixExpression.append(stack.pop());
    }
    return postfixExpression.toString();
  }

  private static int precedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

}
