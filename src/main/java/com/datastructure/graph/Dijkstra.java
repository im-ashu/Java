package com.datastructure.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Dijkstra {

  public static void main(String[] args) {
    int vertices = 7;
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 10));
    graph[1].add(new Edge(1, 0, 10));
    graph[0].add(new Edge(0, 3, 40));
    graph[3].add(new Edge(3, 0, 40));
    graph[1].add(new Edge(1, 2, 10));
    graph[2].add(new Edge(2, 1, 10));
    graph[2].add(new Edge(2, 3, 10));
    graph[3].add(new Edge(3, 2, 10));
    graph[3].add(new Edge(3, 4, 2));
    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 3));
    graph[5].add(new Edge(5, 4, 3));
    graph[4].add(new Edge(4, 6, 8));
    graph[6].add(new Edge(6, 4, 8));
    graph[5].add(new Edge(5, 6, 3));
    graph[6].add(new Edge(6, 5, 3));

    boolean[] visited = new boolean[vertices];
    int[] distance = new int[7];
    int source = 3;
    shortestPaths(graph, source, visited, distance);
    IntStream.range(0, vertices).forEach(e -> System.out.print(distance[e] + " "));
  }

  private static void shortestPaths(ArrayList<Edge>[] graph, int source, boolean[] visited,
      int[] distance) {
    PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(a -> a.wt));
    q.add(new Pair(source, 0, source + ""));
    while (!q.isEmpty()) {
      final Pair rem = q.remove();
      if (visited[rem.v]) {
        continue;
      }
      visited[rem.v] = true;
      System.out.println(source + " -> " + rem.v + " = " + rem.wt + " Path " + rem.psf);
      distance[rem.v] = rem.wt;
      for (Edge edge : graph[rem.v]) {
        if (!visited[edge.nbr]) {
          q.add(new Pair(edge.nbr, rem.wt + edge.wt, rem.psf + edge.nbr));
        }
      }
    }
  }

  static class Edge {

    int src;
    int nbr;
    int wt;

    public Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  static class Pair {

    int v;
    int wt;
    String psf;

    public Pair(int v, int wt, String psf) {
      this.v = v;
      this.wt = wt;
      this.psf = psf;
    }
  }
}