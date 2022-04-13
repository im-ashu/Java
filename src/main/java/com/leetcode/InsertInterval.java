package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

  public static void main(String[] args) {
    InsertInterval insertInterval = new InsertInterval();
    int[][] intervals = {{1, 3}, {4, 9}};
    int[] newInterval = {2, 5};
    int[][] result = insertInterval.insert(intervals, newInterval);
    for (int[] ints : result) {
      System.out.print(ints[0] + " " + ints[1] + ", ");
    }

  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();
    int n = intervals.length;
    if (n == 0) {
      res.add(newInterval);
      return res.toArray(new int[0][]);
    }
    int i = 0;
    while (i < n && intervals[i][1] < newInterval[0]) {
      res.add(intervals[i++]);
    }
    while (i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }
    res.add(newInterval);
    while (i < n) {
      res.add(intervals[i++]);
    }
    return res.toArray(new int[res.size() - 1][]);
  }
}
