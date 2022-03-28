package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

  public static void main(String[] args) {
    int[][] grid = {{2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}};
    System.out.println(orangesRotting(grid));
  }

  public static int orangesRotting(int[][] grid) {
    Queue<Pair> queue = new LinkedList<>();
    int n = grid.length;
    int m = grid[0].length;
    int total = 0;
    int time = 0, rotten = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 || grid[i][j] == 2) {
          total++;
        }
        if (grid[i][j] == 2) {
          queue.add(new Pair(i, j));
        }
      }
    }
    if (total == 0) {
      return 0;
    }
    while (!queue.isEmpty()) {
      int size = queue.size();
      rotten += size;
      if (rotten == total) {
        return time;
      }
      time++;
      for (int i = 0; i < size; i++) {
        Pair p = queue.peek();
        assert p != null;
        if (p.x + 1 < n && grid[p.x + 1][p.y] == 1) {
          grid[p.x + 1][p.y] = 2;
          queue.add(new Pair(p.x + 1, p.y));
        }
        if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
          grid[p.x - 1][p.y] = 2;
          queue.add(new Pair(p.x - 1, p.y));
        }
        if (p.y + 1 < m && grid[p.x][p.y + 1] == 1) {
          grid[p.x][p.y + 1] = 2;
          queue.add(new Pair(p.x, p.y + 1));
        }
        if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
          grid[p.x][p.y - 1] = 2;
          queue.add(new Pair(p.x, p.y - 1));
        }
        queue.poll();
      }
    }
    return -1;
  }

  static class Pair {

    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}