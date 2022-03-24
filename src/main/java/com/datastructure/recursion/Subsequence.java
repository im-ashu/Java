package com.datastructure.recursion;

public class Subsequence {

  public static void main(String[] args) {
    String input = "abc";
    String output = "";
    printSubsequence(input, output);
  }

  private static void printSubsequence(String input, String output) {
    if (input.length() == 0) {
      System.out.print(output + " ");
      return;
    }
    String op2 = output;
    op2 += input.substring(0, 1);
    input = input.substring(1);
    printSubsequence(input, output);
    printSubsequence(input, op2);
  }
}