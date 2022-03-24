package com.interviewbit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CommutableIslands {

  public static void main(String[] args) {
    CommutableIslands c = new CommutableIslands();
    int A = 4;
    ArrayList<ArrayList<Integer>> B = new ArrayList<>();
    B.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
    B.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
    B.add(new ArrayList<>(Arrays.asList(1, 4, 3)));
    B.add(new ArrayList<>(Arrays.asList(4, 3, 2)));
    B.add(new ArrayList<>(Arrays.asList(1, 3, 10)));
    c.solve(A, B);
  }

  public int solve(int A, ArrayList<ArrayList<Integer>> B) {
    ArrayList<Edge>[] graph = new ArrayList[A + 1];
    for (int i = 0; i <= A; i++) {
      graph[i] = new ArrayList<>();
    }
    for (ArrayList<Integer> integers : B) {
      int v1 = integers.get(0);
      int v2 = integers.get(1);
      int wt = integers.get(2);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }
    boolean[] visited = new boolean[A + 1];
    int[] distance = new int[A + 1];
    shortestPath(graph, 1, visited, distance);
    final int sum = Arrays.stream(distance).sum();
    return sum;
  }

  private void shortestPath(ArrayList<Edge>[] graph, int vertex, boolean[] visited,
      int[] distance) {
    PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(a -> a.wt));
    q.add(new Pair(vertex, 0));
    while (!q.isEmpty()) {
      final Pair rem = q.remove();
      if (visited[rem.v]) {
        continue;
      }
      visited[rem.v] = true;
      distance[rem.v] = rem.wt;
      for (Edge edge : graph[rem.v]) {
        if (!visited[edge.nbr]) {
          q.add(new Pair(edge.nbr, edge.wt));
        }
      }
    }
  }

  class Edge {

    int src;
    int nbr;
    int wt;

    public Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  class Pair {

    int v;
    int wt;

    public Pair(int v, int wt) {
      this.v = v;
      this.wt = wt;
    }
  }
}