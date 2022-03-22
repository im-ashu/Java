package com.datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

  static Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) {
    int vertices = 7;
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 3));
    graph[1].add(new Edge(1, 2));
    graph[2].add(new Edge(2, 3));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));
    graph[4].add(new Edge(4, 6));
    graph[5].add(new Edge(5, 6));

    boolean[] visited = new boolean[vertices];
    for (int v = 0; v < vertices; v++) {
      if (!visited[v]) {
        sort(graph, v, visited);
      }
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }

  private static void sort(ArrayList<Edge>[] graph, int v, boolean[] visited) {
    visited[v] = true;
    for (Edge edge : graph[v]) {
      if (!visited[edge.nbr]) {
        sort(graph, edge.nbr, visited);
      }
    }
    stack.add(v);
  }

  static class Edge {

    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }
}