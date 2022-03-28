package com.bitmanipulation;

public class LongestConsecutive1s {

  public static void main(String[] args) {
    int n = 222;
    System.out.println(maxConsecutiveOnes(n));
  }

  public static int maxConsecutiveOnes(int N) {

    // Your code here
    String binary = binaryRepresentation(N);
    int maxSoFar = 0;
    int maxEndingHere = 0;
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '0') {
        maxEndingHere = 0;
      } else {
        maxEndingHere += 1;
      }
      if (maxEndingHere > maxSoFar) {
        maxSoFar = maxEndingHere;
      }
    }
    return maxSoFar;
  }

  private static String binaryRepresentation(int n) {
    if (n == 0) {
      return "";
    }
    return binaryRepresentation(n >> 1) + (n & 1);
  }
}