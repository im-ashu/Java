package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(
        Arrays.asList(97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94,
            57, 1, 53, 8, 44, 68, 90, 24));
    int B = 1;
    System.out.println(books(A, B));
  }

  public static int books(ArrayList<Integer> A, int B) {
    int n = A.size();
    if (B > n) {
      return 0;
    }
    int h = A.stream().mapToInt(integer -> integer).sum();
    int max = Integer.MIN_VALUE;
    for (Integer integer : A) {
      max = Math.max(max, integer);
    }
    int l = max;
    int ans = -1;
    while (l <= h) {
      int mid = l + ((h - l) >> 1);
      if (isPossible(A, B, mid)) {
        ans = mid;
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return ans;
  }

  private static boolean isPossible(ArrayList<Integer> a, int b, int sum) {
    int numStudents = 1;
    int currentSum = 0;
    for (Integer integer : a) {
      if (currentSum + integer > sum) {
        numStudents++;
        currentSum = integer;
        if (numStudents > b) {
          return false;
        }
      } else {
        currentSum += integer;
      }
    }
    return true;
  }
}