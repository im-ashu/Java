package com.datastructure.backtracking;

public class MColoringProblem {

  final int V = 4;
  int[] color;

  public static void main(String[] args) {
    MColoringProblem coloring = new MColoringProblem();
 /* Create following graph and
 test whether it can be colored with 3 colors
 (3)---(2)
 | / |
 | / |
 | / |
 (0)---(1)
 */
    int[][] graph = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0},
    };
    int m = 3; // Number of colors
    coloring.graphColoring(graph, m);
  }

  void printSolution(int[] color) {
    System.out.println("Solution Exists: Following are the assigned colors");
    for (int i = 0; i < V; i++) {
      System.out.print(" " + color[i] + " ");
    }
    System.out.println();
  }

  private void graphColoring(int[][] graph, int m) {
    color = new int[V];
    for (int i = 0; i < V; i++) {
      color[i] = 0;
    }
    if (!graphColoringUtil(graph, color, m, 0)) {
      System.out.println("Solution does not exist");
    } else {
      printSolution(color);
    }
  }

  private boolean graphColoringUtil(int[][] graph, int[] color, int m, int v) {
    if (v == V) {
      return true;
    }
    for (int c = 1; c <= m; c++) {
      if (isSafe(v, graph, color, c)) {
        color[v] = c;
        if (graphColoringUtil(graph, color, m, v + 1)) {
          return true;
        }
        color[v] = 0;
      }
    }
    return false;
  }

  private boolean isSafe(int v, int[][] graph, int[] color, int c) {
    for (int i = 0; i < V; i++) {
      if (graph[i][v] == 1 && c == color[i]) {
        return false;
      }
    }
    return true;
  }
}