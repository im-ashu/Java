package com.interviewbit;

import java.util.ArrayList;

public class FindPermutation {

  public static void main(String[] args) {
    String A = "IIDID";
    int B = 6;
    findPerm(A, B).stream().map(integer -> integer + " ").forEach(System.out::print);
  }

  public static ArrayList<Integer> findPerm(final String A, int B) {
    ArrayList<Integer> res = new ArrayList<>();
    if (B == 1) {
      res.add(B);
      return res;
    }
    int start = 1;
    int end = 0;
    int n = A.length();
    for (int i = 0; i < n; i++) {
      end++;
      if (A.charAt(i) == 'I') {
        for (int j = end; j >= start; j--) {
          res.add(j);
        }
        start = end + 1;
      }
    }
    end++;
    for (int j = end; j >= start; j--) {
      res.add(j);
    }
    return res;
  }
}