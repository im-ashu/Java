package com.datastructure.greedy;

import java.util.stream.IntStream;

public class Dijkstra {

  public static void main(String[] args) {
    int graph[][] = new int[][]{
        //0, 1, 2, 3, 4, 5, 6, 7, 8
        {0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    Dijkstra t = new Dijkstra();
    t.dijkstra(graph, 2);
  }

  private void dijkstra(int[][] graph, int src) {
    int V = graph.length;
    int[] dist = new int[V];
    boolean[] spSet = new boolean[V];

    IntStream.range(0, V).forEach(i -> {
      dist[i] = Integer.MAX_VALUE;
      spSet[i] = false;
    });

    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
      int u = minDistance(dist, spSet);
      spSet[u] = true;

      for (int v = 0; v < V; v++) {
        if (!spSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && (dist[v] > (dist[u]
            + graph[u][v]))) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }
    printSolution(dist);
  }

  private void printSolution(int dist[]) {
    System.out.println("Vertex \t\t Distance from Source");
    int V = dist.length;
   for (int i = 0; i < V; i++) {
    System.out.println(i + " \t\t " + dist[i]);
   }
  }

  private int minDistance(int[] dist, boolean[] spSet) {
    int min = Integer.MAX_VALUE;
    int V = dist.length;
    int minIndex = -1;
    for (int i = 0; i < V; i++) {
      if (!spSet[i] && dist[i] <= min) {
        min = dist[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
}