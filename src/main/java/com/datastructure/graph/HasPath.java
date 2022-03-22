package com.datastructure.graph;

import java.util.ArrayList;

public class HasPath {

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

    int src = 0;
    int dest = 6;
    boolean[] visited = new boolean[vertices];
    String psf = "";
    boolean hasPath = hasPath(graph, src, dest, visited, psf);
    System.out.println(hasPath);
  }

  private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,
      String psf) {
    psf = psf + src;
    if (src == dest) {
      return true;
    }
    visited[src] = true;
    for (Edge edge : graph[src]) {
      if (!visited[edge.nbr]) {
        if (hasPath(graph, edge.nbr, dest, visited, psf)) {
          return true;
        }
      }
    }
    visited[src] = false;
    return false;
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

}