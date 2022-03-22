package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import org.javatuples.Pair;

public class RottenOranges {

  private static int rowCount;
  private static int columnCount;

  public static void main(String[] args) {
    int[][] arr = {{2, 1, 0, 2, 1},
        {1, 0, 1, 2, 1},
        {1, 0, 0, 2, 1}};
    int ans = rottenOranges(arr);
    System.out.println(
        ans == -1 ? "All oranges cannot rot" : String
            .format("Time required for all oranges to rot = %d", ans));
  }

  private static int rottenOranges(int[][] arr) {
    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    int ans = 0;
    rowCount = arr.length;
    for (int i = 0; i < rowCount; i++) {
      columnCount = arr[i].length;
      for (int j = 0; j < columnCount; j++) {
        if (arr[i][j] == 2) {
          queue.offer(makePair(i, j));
        }
      }
    }
    queue.offer(makePair(-1, -1));

    while (!queue.isEmpty()) {
      boolean changed = false;
      while (!isDelimiter(queue)) {
        Pair<Integer, Integer> temp = queue.peek();
        int x = temp.getValue0();
        int y = temp.getValue1();
        if (isValid(x + 1, y)
            && arr[x + 1][y] == 1) {
          if (!changed) {
            changed = true;
            ans++;
          }
          arr[x + 1][y] = 2;
          queue.offer(makePair(x + 1, y));
        }
        if (isValid(x - 1, y)
            && arr[x - 1][y] == 1) {
          if (!changed) {
            changed = true;
            ans++;
          }
          arr[x - 1][y] = 2;
          queue.offer(makePair(x - 1, y));
        }
        if (isValid(x, y + 1)
            && arr[x][y + 1] == 1) {
          if (!changed) {
            changed = true;
            ans++;
          }
          arr[x][y + 1] = 2;
          queue.offer(makePair(x, y + 1));
        }
        if (isValid(x, y - 1)
            && arr[x][y - 1] == 1) {
          if (!changed) {
            changed = true;
            ans++;
          }
          arr[x][y - 1] = 2;
          queue.offer(makePair(x, y - 1));
        }
        queue.poll();
      }
      queue.poll();
      if (!queue.isEmpty()) {
        queue.add(makePair(-1, -1));
      }
    }
    return (checkAll(arr)) ? -1 : ans;
  }

  private static boolean checkAll(int[][] arr) {
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < columnCount; j++) {
        if (arr[i][j] == 1) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isValid(int i, int j) {
    return (i >= 0 && j >= 0 && i < rowCount && j < columnCount);
  }

  private static boolean isDelimiter(Queue<Pair<Integer, Integer>> queue) {
    return (queue.peek().getValue0() == -1) && (queue.peek().getValue1() == -1);
  }

  private static Pair<Integer, Integer> makePair(int i, int j) {
    return new Pair<>(i, j);
  }

}
