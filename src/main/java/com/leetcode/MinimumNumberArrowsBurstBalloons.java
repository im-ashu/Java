package com.leetcode;

import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {

  public static void main(String[] args) {
    int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
    System.out.println(new MinimumNumberArrowsBurstBalloons().findMinArrowShots(points));
  }

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> {
      if (a[1] != b[1]) {
        return a[1] < b[1] ? -1 : 1;
      } else {
        return a[0] < b[0] ? -1 : 1;
      }
    });
    int ans = 0;
    int end = Integer.MIN_VALUE;
    for (int[] point : points) {
      if (ans == 0 || point[0] > end) {
        ans++;
        end = point[1];
      }
    }
    return ans;
  }
}
