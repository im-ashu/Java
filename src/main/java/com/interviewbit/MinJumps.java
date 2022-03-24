package com.interviewbit;

import static java.lang.Integer.MAX_VALUE;

import java.util.ArrayList;
import java.util.Arrays;

public class MinJumps {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 2, 1, 0, 4));
    MinJumps m = new MinJumps();
    System.out.println(m.jump(A));
  }

  public int jump(ArrayList<Integer> A) {
    int n = A.size();
    int[] jumps = new int[n];
    int min;

    jumps[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      if (A.get(i) == 0) {
        jumps[i] = MAX_VALUE;
      } else if ((i + A.get(i)) >= n - 1) {
        jumps[i] = 1;
      } else {
        min = MAX_VALUE;
        int steps = A.get(i);
        for (int j = 1; i + j < n && j <= steps; j++) {
          min = Math.min(jumps[i + j], min);
        }
        if (min == MAX_VALUE) {
          jumps[i] = min;
        } else {
          jumps[i] = 1 + min;
        }
      }
    }
    return jumps[0];
  }

}