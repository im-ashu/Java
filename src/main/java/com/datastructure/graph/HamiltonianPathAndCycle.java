package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HamiltonianPathAndCycle {

  public static void main(String[] args) {
    int vertices = 7;
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));
    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));
    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 3));
    graph[2].add(new Edge(2, 4));
    graph[2].add(new Edge(2, 5));
    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 2));
    graph[3].add(new Edge(3, 4));
    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));
    graph[4].add(new Edge(4, 6));
    graph[5].add(new Edge(5, 2));
    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));
    graph[6].add(new Edge(6, 4));
    graph[6].add(new Edge(6, 5));

    HashSet<Integer> visited = new HashSet<>();
    int src = 0, originalSrc = 0;
    hamiltonianPathAndCycle(graph, src, originalSrc, visited, src + "");
    visited = new HashSet<>();
    System.out.println("----------------------------");
    List<Integer> psf = new ArrayList<>();
    psf.add(src);
    hamiltonianPathAndCycle(graph, src, originalSrc, visited, psf);

  }

  private static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, int src, int originalSrc,
      HashSet<Integer> visited, String psf) {
    if (visited.size() == graph.length - 1) {
      System.out.print(psf);
      boolean cycleFound = false;
      for (Edge edge : graph[src]) {
        if (edge.nbr == originalSrc) {
          cycleFound = true;
          break;
        }
      }
      if (cycleFound) {
        System.out.println("*");
      } else {
        System.out.println(".");
      }
      return;
    }
    visited.add(src);
    for (Edge edge : graph[src]) {
      if (!visited.contains(edge.nbr)) {
        hamiltonianPathAndCycle(graph, edge.nbr, originalSrc, visited, psf + edge.nbr);
      }
    }
    visited.remove(src);
  }

  private static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, int src, int originalSrc,
      HashSet<Integer> visited, List<Integer> psf) {

    if (psf.size() == graph.length && visited.size() == graph.length - 1) {
      System.out.print(psf);
      boolean cycleFound = false;
      for (Edge edge : graph[src]) {
        if (edge.nbr == originalSrc) {
          cycleFound = true;
          break;
        }
      }
      if (cycleFound) {
        System.out.println("*");
      } else {
        System.out.println(".");
      }
      return;
    }
    visited.add(src);
    for (Edge edge : graph[src]) {
      if (!visited.contains(edge.nbr)) {
        psf.add(edge.nbr);
        hamiltonianPathAndCycle(graph, edge.nbr, originalSrc, visited, psf);
        psf.remove(psf.size() - 1);
      }
    }
    visited.remove(src);
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