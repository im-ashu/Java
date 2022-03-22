package com.datastructure.dynamicprogramming.mcm;

public class EggDroppingProblem {

  public static void main(String[] args) {
    int e = 2;
    int f = 4;
    int minWaysInWorstCase = eggDrop(e, f);
    System.out.println(minWaysInWorstCase);
  }

  private static int eggDrop(int e, int f) {
    if (f == 0 || f == 1 || e == 1) {
      return f;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= f; i++) {
      int temp = 1 + Math.max(eggDrop(e - 1, i - 1), eggDrop(e, f - i));
      min = Math.min(min, temp);
    }
    return min;
  }
}