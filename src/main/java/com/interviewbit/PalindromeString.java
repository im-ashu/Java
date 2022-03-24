package com.interviewbit;

public class PalindromeString {

  public static void main(String[] args) {
    String A = "race a car";
    System.out.println(isPalindrome(A));
  }

  public static int isPalindrome(String A) {
    int i = 0;
    int j = A.length() - 1;
    A = A.toLowerCase();
    while (i < j) {
      if (isAlphaNumeric(A.charAt(i)) && isAlphaNumeric(A.charAt(j))) {
        if (A.charAt(i) != A.charAt(j)) {
          return 0;
        } else {
          i++;
          j--;
        }
      }
      if (!isAlphaNumeric(A.charAt(i))) {
        i++;
      }
      if (!isAlphaNumeric(A.charAt(j))) {
        j--;
      }
    }
    return 1;
  }

  private static boolean isAlphaNumeric(char c) {
    if (c - 'a' >= 0 && c - 'a' <= 26) {
      return true;
    }
    return c - '0' >= 0 && c - '0' <= 9;
  }
}