package com.codestudio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestPathUnweighted {

  public static void main(String[] args) {
    int[][] edges = {
        {1, 2},
        {2, 3},
        {3, 4},
        {1, 3}};

    int s = 1;
    int t = 4;
    LinkedList<Integer> result = shortestPath(edges, 4, 4, s, t);
    System.out.println(result);
  }

  public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
    // Write your code here.

    int rows = n + 1;
    ArrayList<Edge>[] graph = new ArrayList[rows];
    for (int i = 0; i < rows; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] ints : edges) {
      int a = ints[0];
      int b = ints[1];
      graph[a].add(new Edge(a, b, 1));
      graph[b].add(new Edge(b, a, 1));
    }

    boolean[] visited = new boolean[rows];
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));
    pq.add(new Pair(s, 0, "" + s));
    LinkedList<Integer> ans = new LinkedList<>();
    while (!pq.isEmpty()) {
      Pair rem = pq.poll();
      if (visited[rem.src]) {
        continue;
      }
      if (rem.src == t) {
        String[] p = rem.psf.split(" ");
        for (String vertices : p) {
          if (!vertices.equalsIgnoreCase(" ")) {
            ans.add(Integer.parseInt(vertices));
          }
        }
        return ans;
      }
      visited[rem.src] = true;
      for (Edge edge : graph[rem.src]) {
        if (!visited[edge.nbr]) {
          pq.add(new Pair(edge.nbr, rem.wt + edge.wt, rem.psf + " " + edge.nbr));
        }
      }

    }
    return ans;
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

    int src;
    int wt;
    String psf;

    Pair(int s, int w, String p) {
      src = s;
      wt = w;
      psf = p;
    }
  }

}