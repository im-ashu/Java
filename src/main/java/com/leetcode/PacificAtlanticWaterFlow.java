package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

  int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

  public static void main(String[] args) {
    int[][] heights = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}};

    List<List<Integer>> result = new PacificAtlanticWaterFlow().pacificAtlantic(heights);
    for (List<Integer> coordinates : result) {
      for (Integer point : coordinates) {
        System.out.print(point + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> ans = new ArrayList<>();
    int rows = heights.length;
    int cols = heights[0].length;
    boolean[][] pacificVisited = new boolean[rows][cols];
    boolean[][] atlanticVisited = new boolean[rows][cols];
    Queue<List<Integer>> pacificQueue = new LinkedList<>();
    Queue<List<Integer>> atlanticQueue = new LinkedList<>();
    for (int i = 0; i < rows; i++) {
      pacificQueue.add(new ArrayList<>(Arrays.asList(i, 0)));
      atlanticQueue.add(new ArrayList<>(Arrays.asList(i, cols - 1)));
      pacificVisited[i][0] = true;
      atlanticVisited[i][cols - 1] = true;
    }
    for (int i = 0; i < cols; i++) {
      pacificQueue.add(new ArrayList<>(Arrays.asList(0, i)));
      atlanticQueue.add(new ArrayList<>(Arrays.asList(rows - 1, i)));
      pacificVisited[0][i] = true;
      atlanticVisited[rows - 1][i] = true;
    }

    visit(heights, pacificQueue, pacificVisited);
    visit(heights, atlanticQueue, atlanticVisited);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (pacificVisited[i][j] && atlanticVisited[i][j]) {
          ans.add(new ArrayList<>(Arrays.asList(i, j)));
        }
      }
    }
    return ans;
  }

  private void visit(int[][] heights, Queue<List<Integer>> queue, boolean[][] visited) {
    while (!queue.isEmpty()) {
      List<Integer> currentCoordinates = queue.poll();
      for (int[] points : dir) {
        Integer currentX = currentCoordinates.get(0);
        Integer currentY = currentCoordinates.get(1);

        int x = currentX + points[0];
        int y = currentY + points[1];
        if (x < 0 || y < 0 || x >= heights.length || y >= heights[0].length
            || heights[x][y] < heights[currentX][currentY] || visited[x][y]) {
          continue;
        }
        visited[x][y] = true;
        queue.add(new ArrayList<>(Arrays.asList(x, y)));
      }

    }
  }
}