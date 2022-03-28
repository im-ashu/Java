package com.leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {

  public static void main(String[] args) {
    int[][] intervals = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99},
        {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
    System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
  }

  public int eraseOverlapIntervals(int[][] intervals) {
    int count = 1;
    Arrays.sort(intervals, (a, b) -> {
      if (a[1] != b[1]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });
    int length = intervals.length;
    int end = intervals[0][1];
    for (int i = 1; i < length; i++) {
      if (intervals[i][0]
          >= end) { //Non-overlapping condition - start on current interval greater than previous end
        end = intervals[i][1];
        count++;
      }
    }
    return length - count;
  }

}
