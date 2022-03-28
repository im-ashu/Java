package com.leetcode;

public class FinalValueAfterOperations {

  public static void main(String[] args) {
    String[] operations = {"--X", "X++", "X++"};
    System.out.println(new FinalValueAfterOperations().finalValueAfterOperations(operations));
  }

  public int finalValueAfterOperations(String[] operations) {
    int count = 0;
    for (String operation : operations) {
      switch (operation) {
        case "X++":
        case "++X":
          count++;
          break;
        default:
          count--;
      }
    }
    return count;
  }
}
