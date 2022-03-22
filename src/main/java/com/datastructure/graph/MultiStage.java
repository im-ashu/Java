package com.datastructure.graph;

public class MultiStage {

  public static void main(String[] args) {
    // Graph stored in the form of an
    // adjacency Matrix
    int[][] graph = new int[][]{{0, 1, 2, 5, 0, 0, 0, 0},
        {0, 0, 0, 0, 4, 11, 0, 0},
        {0, 0, 0, 0, 9, 5, 16, 0},
        {0, 0, 0, 0, 0, 0, 2, 0},
        {0, 0, 0, 0, 0, 0, 0, 18},
        {0, 0, 0, 0, 0, 0, 0, 13},
        {0, 0, 0, 0, 0, 0, 0, 2}};

    System.out.println(shortestDist(graph));
  }

  private static int shortestDist(int[][] graph) {
    int n = graph.length;
    int stages = 4;
    int[] P = new int[stages];
    n += 1; //Last vertex is not accounted for.
    int[] cost = new int[n];
    int[] d = new int[n];
    cost[n - 1] = 0;
    d[n - 1] = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      cost[i] = Integer.MAX_VALUE;
      for (int j = i + 1; j < n; j++) {
        if (graph[i][j] != 0 && (graph[i][j] + cost[j] < cost[i])) {
          cost[i] = graph[i][j] + cost[j];
          d[i] = j;
        }
      }
    }
    P[0] = 0;
    P[stages - 1] = n - 1;
    for (int i = 1; i < stages - 1; i++) {
      P[i] = d[P[i - 1]];
    }
    for (int i = 0; i < stages; i++) {
      System.out.print(((char) (P[i] + 'A')) + " ");
    }
    System.out.println();
    return cost[0];
  }
}