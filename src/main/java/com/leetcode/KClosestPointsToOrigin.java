package com.leetcode;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KClosestPointsToOrigin {

  public static void main(String[] args) {
    int[][] points = {{1, 3}, {-2, 2}};
    int k = 1;
    KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
    final int[][] result = kClosestPointsToOrigin.kClosest(points, k);
    IntStream.range(0, k).mapToObj(i -> "{ " + result[i][0] + ", " + result[i][1] + " }")
        .forEach(System.out::print);
  }

  public int[][] kClosest(int[][] points, int k) {
    int[][] result = new int[k][2];
    int n = points.length;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
      Double distanceA = Math.pow(points[a][0], 2) + Math.pow(points[a][1], 2);
      Double distanceB = Math.pow(points[b][0], 2) + Math.pow(points[b][1], 2);
      return distanceB.compareTo(distanceA);
    });
    for (int i = 0; i < n; i++) {
      maxHeap.add(i);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    int index = 0;
    while (!maxHeap.isEmpty()) {
      int i = maxHeap.poll();
      result[index][0] = points[i][0];
      result[index][1] = points[i][1];
      index++;
    }
    return result;
  }
}