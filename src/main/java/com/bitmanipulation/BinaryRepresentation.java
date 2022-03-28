package com.bitmanipulation;

public class BinaryRepresentation {

  public static void main(String[] args) {
    int n = 7;
    System.out.println(binaryRepresentation(n));
  }

  private static String binaryRepresentation(int n) {
    if (n == 0) {
      return "";
    }
    return binaryRepresentation(n >> 1) + (n & 1);
  }
}