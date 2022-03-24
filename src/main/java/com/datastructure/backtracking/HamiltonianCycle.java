package com.datastructure.backtracking;

import java.util.stream.IntStream;

public class HamiltonianCycle {

  public static void main(String[] args) {
    HamiltonianCycle hamiltonian =
        new HamiltonianCycle();
 /* Let us create the following graph
 (0)--(1)--(2)
 | / \ |
 | / \ |
 | / \ |
 (3)-------(4) */
    int[][] graph1 = {{0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 1},
        {0, 1, 1, 1, 0},
    };

    // Print the solution
    hamiltonian.hamCycle(graph1);
  }

  void printSolution(int[] path) {
    System.out.println("Solution Exists: Following" +
        " is one Hamiltonian Cycle");
    for (int j : path) {
      System.out.print(" " + j + " ");
    }

    // Let us print the first vertex again to show the
    // complete cycle
    System.out.println(" " + path[0] + " ");
  }

  private void hamCycle(int[][] graph) {
    int V = graph.length;
    int[] path = IntStream.range(0, V).map(i -> -1).toArray();
    path[0] = 0;
    if (hamCycleUtil(graph, path, 1)) {
      printSolution(path);
    } else {
      System.out.println("\nSolution does not exist");
    }
  }

  private boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
    int V = graph.length;
    if (pos == V) {
      return graph[path[pos - 1]][path[0]] == 1;
    }
    for (int v = 1; v < V; v++) {
      if (isSafe(v, graph, path, pos)) {
        path[pos] = v;
        if (hamCycleUtil(graph, path, pos + 1)) {
          return true;
        }
        path[pos] = -1;
      }
    }
    return false;
  }

  private boolean isSafe(int v, int[][] graph, int[] path, int pos) {
    if (graph[path[pos - 1]][v] == 0) {
      return false;
    }
    for (int i = 0; i < pos; i++) {
      if (path[i] == v) {
        return false;
      }
    }
    return true;
  }
}