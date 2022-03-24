package com.interviewbit;

public class LengthOfLastWord {

  public static void main(String[] args) {
    String A = "Hello World";
    System.out.println(lengthOfLastWord(A));
  }

  public static int lengthOfLastWord(final String A) {
    int n = A.length();
    int count = 0;
    boolean charFlag = false;
    for (int i = n - 1; i >= 0; i--) {
      if (A.charAt(i) == ' ') {
        if (charFlag) {
          return count;
        }
      } else {
        charFlag = true;
        count++;
      }
    }
    return count;
  }
}