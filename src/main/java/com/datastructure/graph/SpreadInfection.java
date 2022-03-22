package com.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class SpreadInfection {

  public static void main(String[] args) {
    int vertices = 8;
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[1].add(new Edge(1, 0));
    graph[0].add(new Edge(0, 3));
    graph[3].add(new Edge(3, 0));
    graph[1].add(new Edge(1, 2));
    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 2));
    graph[3].add(new Edge(3, 4));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));
    graph[5].add(new Edge(5, 4));
    graph[4].add(new Edge(4, 7));
    graph[7].add(new Edge(7, 4));
    graph[5].add(new Edge(5, 6));
    graph[6].add(new Edge(6, 5));
    graph[6].add(new Edge(6, 7));
    graph[7].add(new Edge(7, 6));

    int[] visited = new int[vertices];
    Arrays.fill(visited, -1);
    int source = 0;
    int T = 4;
    spreadInfection(graph, source, visited, T);
  }

  private static void spreadInfection(ArrayList<Edge>[] graph, int source, int[] visited, int t) {
    ArrayDeque<Pair> q = new ArrayDeque<>();
    q.add(new Pair(source, 1));
    while (!q.isEmpty()) {
      final Pair rem = q.remove();
      if (visited[rem.v] != -1) {
        continue;
      }
      if (rem.time > t) {
        return;
      }
      visited[rem.v] = rem.time;
      System.out.print(rem.v + " ");
      for (Edge edge : graph[rem.v]) {
        if (visited[edge.nbr] == -1) {
          q.add(new Pair(edge.nbr, rem.time + 1));
        }
      }
    }
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
    int time;

    public Pair(int v, int time) {
      this.v = v;
      this.time = time;
    }
  }

}