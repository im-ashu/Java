package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysToFormMaxHeap {

  private static final long M = 1000000007;
  static int[] t = new int[101];
  List<List<Integer>> nCrdp = new ArrayList<>();

  {
    for (int i = 0; i < 101; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < 101; j++) {
        list.add(j, -1);
      }
      nCrdp.add(list);
    }
  }

  public static void main(String[] args) {
    int A = 100;
    WaysToFormMaxHeap w = new WaysToFormMaxHeap();
    System.out.println(w.solve(A));
  }

  public int solve(int A) {
    Arrays.fill(t, -1);
    return getNumOfMaxHeap(A);
  }

  private int getNumOfMaxHeap(int a) {
    if (a <= 1) {
      return 1;
    }
    if (t[a] != -1) {
      return t[a];
    }
    int L = numOfNodesOnLeft(a);
    int waysToChoseL = (int) (chose(a - 1, L) % M);
    int maxHeapsUsingL = (int) (getNumOfMaxHeap(L) % M);
    int maxHeapsUsingR = (int) (getNumOfMaxHeap(a - 1 - L) % M);
    int ans = (int) (((waysToChoseL % M) * (maxHeapsUsingL * maxHeapsUsingR) % M) % M);
    t[a] = ans;
    return ans;
  }

  private int chose(int n, int r) {
    if (r > n) {
      return 0;
    }
   if (n <= 1) {
    return 1;
   }
   if (r == 0) {
    return 1;
   }
   if (r == 1) {
    return n;
   }
    if (nCrdp.get(n).get(r) != -1) {
      return nCrdp.get(n).get(r);
    }
    int res = (int) ((chose(n - 1, r - 1) % M + chose(n - 1, r)) % M);
    nCrdp.get(n).set(r, res);
    return res;
  }

  private int numOfNodesOnLeft(int a) {
    int h = (int) (Math.log(a) / Math.log(2));
    int x = (int) ((int) ((Math.pow(2, h - 1)) - 1) % M);
    int y = (int) ((int) Math.min(Math.pow(2, (h - 1)), (a - (Math.pow(2, h) - 1))) % M);
    return x + y;
  }

}