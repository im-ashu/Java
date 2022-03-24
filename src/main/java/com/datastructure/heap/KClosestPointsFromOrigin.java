package com.datastructure.heap;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KClosestPointsFromOrigin {

  public static void main(String[] args) {
    int[][] pointsArr = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
    int n = pointsArr.length;
    int k = 2;
    int[][] result = kClosesPoints(pointsArr, n, k);
    IntStream.range(0, k).mapToObj(i -> "{ " + result[i][0] + ", " + result[i][1] + " }")
        .forEach(System.out::print);
  }

  private static int[][] kClosesPoints(int[][] pointsArr, int n, int k) {
    int[][] result = new int[k][2];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
      Double distanceOfAPoint = Math.pow(pointsArr[a][0], 2) + Math.pow(pointsArr[a][1], 2);
      Double distanceOfBPoint = Math.pow(pointsArr[b][0], 2) + Math.pow(pointsArr[b][1], 2);
      return distanceOfBPoint.compareTo(distanceOfAPoint);
    });

    for (int i = 0; i < n; i++) {
      maxHeap.add(i);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    int index = 0;
    while (!maxHeap.isEmpty()) {
      Integer row = maxHeap.poll();
      result[index] = pointsArr[row];
      index++;
    }

    return result;
  }
}