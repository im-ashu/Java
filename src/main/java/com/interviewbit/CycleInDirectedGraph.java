package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleInDirectedGraph {

  public static void main(String[] args) {
    CycleInDirectedGraph c = new CycleInDirectedGraph();
    int A = 5;
    ArrayList<ArrayList<Integer>> B = new ArrayList<>();
    B.add(new ArrayList<>(Arrays.asList(1, 2)));
    B.add(new ArrayList<>(Arrays.asList(2, 3)));
    B.add(new ArrayList<>(Arrays.asList(3, 4)));
    B.add(new ArrayList<>(Arrays.asList(4, 5)));
    System.out.println(c.solve(A, B));
  }

  public int solve(int A, ArrayList<ArrayList<Integer>> B) {
    ArrayList<Edge>[] graph = new ArrayList[A + 1];
    for (int i = 0; i <= A; i++) {
      graph[i] = new ArrayList<>();
    }
    for (ArrayList<Integer> integers : B) {
      int v1 = integers.get(0);
      int v2 = integers.get(1);
      graph[v1].add(new Edge(v1, v2));
    }
    boolean[] visited = new boolean[A + 1];
    boolean detectCycle = false;
    for (int i = 1; i <= A; i++) {
      if (!visited[i]) {
        if (detectCycle(graph, i, visited)) {
          detectCycle = true;
          break;
        }
      }
    }
    return detectCycle ? 1 : 0;
  }

  private boolean detectCycle(ArrayList<Edge>[] graph, int source, boolean[] visited) {
    visited[source] = true;
    for (Edge e : graph[source]) {
      if (!visited[e.nbr]) {
        if (detectCycle(graph, e.nbr, visited)) {
          return true;
        }
      } else {
        return true;
      }
    }
    visited[source] = false;
    return false;
  }

  class Edge {

    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }
}