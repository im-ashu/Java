package com.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PrintAllPath {

  static TreeSet<String> result = new TreeSet<>();

  public static void main(String[] args) {
    int vertices = 7;
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 10));
    graph[1].add(new Edge(1, 0, 10));
    graph[0].add(new Edge(0, 2, 10));
    graph[2].add(new Edge(2, 0, 10));
    graph[1].add(new Edge(1, 3, 10));
    graph[3].add(new Edge(3, 1, 10));
    graph[2].add(new Edge(2, 3, 10));
    graph[3].add(new Edge(3, 2, 10));
    graph[2].add(new Edge(2, 4, 10));
    graph[4].add(new Edge(4, 2, 10));
    graph[3].add(new Edge(3, 4, 10));
    graph[4].add(new Edge(4, 3, 10));
    graph[4].add(new Edge(4, 5, 10));
    graph[5].add(new Edge(5, 4, 10));
    graph[5].add(new Edge(5, 6, 10));
    graph[6].add(new Edge(6, 5, 10));

    int src = 0;
    int dest = 6;
    boolean[] visited = new boolean[vertices];
    String psf = String.valueOf(src);
    printPath(graph, src, dest, visited, psf);
    if (!result.isEmpty()) {
      for (String path : result) {
        System.out.println(path);
      }
    }
    System.out.println();
    System.out.println("--------------ArrayList--------------");
    visited = new boolean[vertices];
    printPath(graph, src, dest, visited, new ArrayList<>());
  }

  private static void printPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,
      String psf) {
    if (src == dest) {
      result.add(psf);
      return;
    }
    visited[src] = true;
    for (Edge edge : graph[src]) {
      if (!visited[edge.nbr]) {
        printPath(graph, edge.nbr, dest, visited, psf + edge.nbr);
      }
    }
    visited[src] = false;
  }

  private static void printPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,
      List<Integer> path) {
    path.add(src);
    if (src == dest) {
      for (Integer integer : path) {
        System.out.print(integer);
      }
      System.out.println();
    }
    visited[src] = true;
    for (Edge edge : graph[src]) {
      if (!visited[edge.nbr]) {
        printPath(graph, edge.nbr, dest, visited, path);
      }
    }
    visited[src] = false;
    path.remove(path.size() - 1);
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