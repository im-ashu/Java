package com.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithSpaces {

  public static void main(String[] args) {
    String input = "ABC";
    String output = input.substring(0, 1);
    input = input.substring(1);
    List<String> result = new ArrayList<>();
    printPermutations(input, output, result);
    result.forEach(System.out::println);
  }

  private static void printPermutations(String input, String output, List<String> res) {
    if (input.length() == 0) {
      res.add(output);
      return;
    }
    String firstCharacter = input.substring(0, 1);
    String op2 = output + " " + firstCharacter;
    String op1 = output + firstCharacter;
    input = input.substring(1);
    printPermutations(input, op2, res);
    printPermutations(input, op1, res);
  }
}