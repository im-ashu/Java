package com.hackerrank.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the isBalanced function below.
  static String isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    int bound = s.length();
    for (int i = 0; i < bound; i++) {
      Character character = s.charAt(i);
      if (character == '(' || character == '[' || character == '{') {
        stack.push(character);
      } else {
        if (stack.isEmpty()) {
          return "NO";
        }
        Character pop = stack.pop();
        if ((pop == '(' && character != ')') || (pop == '[' && character != ']') || (pop == '{'
            && character != '}')) {
          return "NO";
        }
      }
    }
    if (!stack.isEmpty()) {
      return "NO";
    }
    return "YES";
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BalancedBrackets.txt"));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      String s = scanner.nextLine();

      String result = isBalanced(s);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
