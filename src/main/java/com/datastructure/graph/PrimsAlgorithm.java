package com.datastructure.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

  public static void main(String[] args) {
    int vertices = 8;
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
    int source = 0;
    mst(graph, source, visited);
  }

  private static void mst(ArrayList<Edge>[] graph, int source, boolean[] visited) {
    PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(a -> a.wt));
    q.add(new Pair(source, 0, -1));
    while (!q.isEmpty()) {
      final Pair rem = q.remove();
      if (visited[rem.v]) {
        continue;
      }
      if (rem.av != -1) {
        System.out.println(rem.av + " -> " + rem.v + " = " + rem.wt);
      }
      visited[rem.v] = true;
      for (Edge edge : graph[rem.v]) {
        if (!visited[edge.nbr]) {
          q.add(new Pair(edge.nbr, edge.wt, rem.v));
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
    int av;

    public Pair(int v, int wt, int av) {
      this.v = v;
      this.wt = wt;
      this.av = av;
    }
  }
}