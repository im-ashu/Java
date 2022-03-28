package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

  private boolean isPossible = true;
  private List<Integer> topologicalOrder = new ArrayList<>();

  public static void main(String[] args) {
    int[][] prerequisites = {{1, 0}};
    int numCourses = 2;
    for (int i : new CourseScheduleII().findOrder(numCourses, prerequisites)) {
      System.out.print(i + " ");
    }
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = new List[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] prerequisite : prerequisites) {
      int src = prerequisite[0];
      int nbr = prerequisite[1];
      graph[src].add(nbr);
    }
    int[] visited = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (visited[i] == 0) {
        dfs(graph, visited, i);
      }
    }
    int[] order;
    if (isPossible) {
      order = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
        order[i] = topologicalOrder.get(i);
      }
    } else {
      order = new int[0];
    }
    return order;
  }

  private void dfs(List<Integer>[] graph, int[] visited, int src) {
    if (!isPossible) {
      return;
    }
    visited[src] = 1;
    for (Integer edge : graph[src]) {
      if (visited[edge] == 0) {
        dfs(graph, visited, edge);
      } else if (visited[edge] == 1) {
        isPossible = false;
      }
    }
    visited[src] = 2;
    topologicalOrder.add(src);
  }
}