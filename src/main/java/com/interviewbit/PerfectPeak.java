package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class PerfectPeak {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 3, 10));
    System.out.println(perfectPeak(A));
  }

  public static int perfectPeak(ArrayList<Integer> A) {
    int n = A.size();
    int[] mx = new int[n];
    int[] mn = new int[n];
    mx[0] = A.get(0);
    mn[n - 1] = A.get(n - 1);
    int mxx = mx[0];
    int mnn = mn[n - 1];
    for (int i = 1; i < n; i++) {
      mxx = Math.max(mxx, A.get(i));
      mx[i] = mxx;
    }
    for (int i = n - 2; i >= 0; i--) {
      mnn = Math.min(mnn, A.get(i));
      mn[i] = mnn;
    }
    for (int i = 1; i < n - 1; i++) {
      if (mn[i] == mx[i] && mn[i] != mn[i + 1] && mx[i - 1] != mx[i] && mx[i] == A.get(i)) {
        return 1;
      }
    }
    return 0;
  }
}