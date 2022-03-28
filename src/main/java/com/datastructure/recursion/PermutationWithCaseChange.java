package com.datastructure.recursion;

import java.util.ArrayList;

public class PermutationWithCaseChange {

  public static void main(String[] args) {
    String ip = "ABC";
    String op = "";
    ip = ip.toLowerCase();
    ArrayList<String> s = new ArrayList<>();
    permutations(ip, op, s);
    s.forEach(e -> System.out.print("(" + e + ")"));
    System.out.println();
    permute(ip);
  }

  private static void permutations(String ip, String op, ArrayList<String> s) {
    if (ip.isEmpty()) {
      s.add(op);
      return;
    }
    String op1 = op + ((char) (ip.charAt(0) - 32));
    String op2 = op + ip.charAt(0);
    ip = ip.substring(1);
    permutations(ip, op1, s);
    permutations(ip, op2, s);
  }

  static void permute(String input) {
    int n = input.length();

    // Number of permutations is 2^n
    int max = 1 << n;

    // Converting string to lower case
    input = input.toLowerCase();

    // Using all subsequences and permuting them
    for (int i = 0; i < max; i++) {
      char[] combination = input.toCharArray();

      // If j-th bit is set, we convert it to upper case
      for (int j = 0; j < n; j++) {
        if (((i >> j) & 1) == 1) {
          combination[j] = (char) (combination[j] - 32);
        }
      }

      // Printing current combination
      System.out.print(combination);
      System.out.print(" ");
    }
  }
}