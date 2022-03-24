package com.interviewbit;

public class AmazingSubarrays {

  public static void main(String[] args) {
    String A = "AEEC";
    System.out.println(solve(A));
  }

  public static int solve(String A) {
    long count = 0;
    int m = 10003;
    int n = A.length();
    A = A.toLowerCase();
    for (int i = 0; i < n; i++) {
      if (isVowel(A.charAt(i))) {
        count = (count + (n - i)) % m;
      }
    }
    return (int) count;
  }

  private static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}