package com.codestudio;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PairSum {

  public static void main(String[] args) {
    int[] arr = {2, -6, 2, 5, 2};
    int s = 4;
    for (int[] ints : pairSum(arr, s)) {
      System.out.print(ints[0] + "," + ints[1] + " ");
    }

  }

  public static int[][] pairSum(int[] arr, int s) {
    // Write your code here.
    PriorityQueue<int[]> res = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    int n = arr.length;
    if (n == 0) {
      return new int[0][0];
    }
    HashSet<Integer> set = new HashSet<>();
    for (int j : arr) {
      int xs = s - j;
      if (set.contains(xs)) {
        res.add(new int[]{xs, j});
      }
      set.add(j);
    }
    int[][] resArr = new int[res.size()][2];
    int index = 0;
    while (!res.isEmpty()) {
      int[] nums = res.poll();
      resArr[index][0] = nums[0];
      resArr[index][1] = nums[1];
      index++;
    }
    return resArr;
  }
}