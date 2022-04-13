package com.leetcode;

import java.util.Stack;

public class BaseballGame {

  public static void main(String[] args) {
    BaseballGame baseballGame = new BaseballGame();
    String[] ops = {"1"};
    System.out.println(baseballGame.calPoints(ops));
  }

  public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    for (String operation : ops) {
      switch (operation) {
        case "C":
          stack.pop();
          break;
        case "D":
          stack.push((stack.peek() << 1));
          break;
        case "+":
          Integer second = stack.pop();
          Integer first = stack.pop();
          int sum = first + second;
          stack.push(first);
          stack.push(second);
          stack.push(sum);
          break;
        default:
          stack.push(Integer.parseInt(operation));
          break;
      }
    }
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }
}
