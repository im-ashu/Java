package com.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DetectCycle {

  public static void main(String[] args) {
    int vertices = 7;
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 2));

    graph[4].add(new Edge(4, 5));
    graph[5].add(new Edge(5, 4));
    graph[4].add(new Edge(4, 6));
    graph[6].add(new Edge(6, 4));
    graph[5].add(new Edge(5, 6));
    graph[6].add(new Edge(6, 5));

    boolean[] visited = new boolean[vertices];
    for (int i = 0; i < vertices; i++) {
      if (!visited[i]) {
        if (breadthFirstSearch(graph, visited, i)) {
          System.out.println("Cycle detected");
        }
      }
    }
  }

  private static boolean breadthFirstSearch(ArrayList<Edge>[] graph, boolean[] visited, int src) {
    ArrayDeque<Pair> q = new ArrayDeque<>();
    q.add(new Pair(src, src + ""));
    while (!q.isEmpty()) {
      final Pair currentVertex = q.remove();
      if (visited[currentVertex.v]) {
        return true;
      }
      visited[currentVertex.v] = true;
      for (Edge edge : graph[currentVertex.v]) {
        if (!visited[edge.nbr]) {
          q.add(new Pair(edge.nbr, currentVertex.psf + edge.nbr));
        }
      }
    }
    return false;
  }

  static class Edge {

    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  static class Pair {

    int v;
    String psf;

    public Pair(int v, String psf) {
      this.v = v;
      this.psf = psf;
    }
  }
}