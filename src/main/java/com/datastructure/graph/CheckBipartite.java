package com.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckBipartite {

  public static void main(String[] args) {
    int vertices = 8;
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 2));

 /*graph[4].add(new Edge(4, 5));
 graph[5].add(new Edge(5, 4));
 graph[4].add(new Edge(4, 6));
 graph[6].add(new Edge(6, 4));
 graph[5].add(new Edge(5, 6));
 graph[6].add(new Edge(6, 5));*/

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
    boolean bipartite = false;
    for (int v = 0; v < vertices; v++) {
      if (visited[v] == -1) {
        bipartite = checkBipartite(graph, v, visited);
        if (!bipartite) {
          break;
        }
      }
    }
    if (bipartite) {
      System.out.println("Bipartite");
    } else {
      System.out.println("Not Bipartite");
    }
  }

  private static boolean checkBipartite(ArrayList<Edge>[] graph, int source, int[] visited) {
    ArrayDeque<Pair> q = new ArrayDeque<>();
    q.add(new Pair(source, source + "", 0));
    while (!q.isEmpty()) {
      final Pair rem = q.remove();
      if (visited[rem.v] != -1 && visited[rem.v] != rem.level) {
        return false;
      }
      visited[rem.v] = rem.level;
      for (Edge edge : graph[rem.v]) {
        if (visited[edge.nbr] == -1) {
          q.add(new Pair(edge.nbr, rem.psf + edge.nbr, rem.level + 1));
        }
      }
    }
    return true;
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
    int level;

    public Pair(int v, String psf, int level) {
      this.v = v;
      this.psf = psf;
      this.level = level;
    }
  }
}