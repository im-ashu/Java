package com.interviewbit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class CycleInUndirectedGraph {

  public static void main(String[] args) {
    CycleInUndirectedGraph c = new CycleInUndirectedGraph();
    int A = 88;
    ArrayList<ArrayList<Integer>> B = new ArrayList<>();
    B.add(new ArrayList<>(Arrays.asList(6, 45)));
    B.add(new ArrayList<>(Arrays.asList(29, 81)));
    B.add(new ArrayList<>(Arrays.asList(7, 8)));
    B.add(new ArrayList<>(Arrays.asList(67, 76)));
    B.add(new ArrayList<>(Arrays.asList(40, 76)));
    B.add(new ArrayList<>(Arrays.asList(7, 73)));
    B.add(new ArrayList<>(Arrays.asList(9, 20)));
    B.add(new ArrayList<>(Arrays.asList(56, 63)));
    B.add(new ArrayList<>(Arrays.asList(52, 57)));
    B.add(new ArrayList<>(Arrays.asList(22, 31)));
    B.add(new ArrayList<>(Arrays.asList(26, 76)));
    B.add(new ArrayList<>(Arrays.asList(14, 58)));
    B.add(new ArrayList<>(Arrays.asList(31, 69)));
    B.add(new ArrayList<>(Arrays.asList(30, 31)));
    B.add(new ArrayList<>(Arrays.asList(56, 85)));
    B.add(new ArrayList<>(Arrays.asList(22, 57)));
    B.add(new ArrayList<>(Arrays.asList(12, 42)));
    B.add(new ArrayList<>(Arrays.asList(19, 78)));
    B.add(new ArrayList<>(Arrays.asList(12, 85)));
    B.add(new ArrayList<>(Arrays.asList(72, 85)));
    B.add(new ArrayList<>(Arrays.asList(3, 41)));
    B.add(new ArrayList<>(Arrays.asList(32, 87)));
    B.add(new ArrayList<>(Arrays.asList(31, 48)));
    B.add(new ArrayList<>(Arrays.asList(17, 81)));
    B.add(new ArrayList<>(Arrays.asList(2, 63)));
    B.add(new ArrayList<>(Arrays.asList(25, 78)));
    B.add(new ArrayList<>(Arrays.asList(49, 51)));
    B.add(new ArrayList<>(Arrays.asList(30, 61)));
    B.add(new ArrayList<>(Arrays.asList(7, 54)));
    B.add(new ArrayList<>(Arrays.asList(79, 80)));
    B.add(new ArrayList<>(Arrays.asList(23, 37)));
    B.add(new ArrayList<>(Arrays.asList(25, 32)));
    B.add(new ArrayList<>(Arrays.asList(54, 63)));
    B.add(new ArrayList<>(Arrays.asList(7, 28)));
    B.add(new ArrayList<>(Arrays.asList(41, 58)));
    B.add(new ArrayList<>(Arrays.asList(45, 52)));
    B.add(new ArrayList<>(Arrays.asList(77, 78)));
    B.add(new ArrayList<>(Arrays.asList(26, 53)));
    B.add(new ArrayList<>(Arrays.asList(54, 83)));
    B.add(new ArrayList<>(Arrays.asList(26, 75)));
    B.add(new ArrayList<>(Arrays.asList(61, 72)));
    B.add(new ArrayList<>(Arrays.asList(57, 82)));
    B.add(new ArrayList<>(Arrays.asList(9, 36)));
    B.add(new ArrayList<>(Arrays.asList(30, 73)));
    B.add(new ArrayList<>(Arrays.asList(12, 17)));
    B.add(new ArrayList<>(Arrays.asList(24, 55)));
    B.add(new ArrayList<>(Arrays.asList(47, 68)));
    B.add(new ArrayList<>(Arrays.asList(12, 64)));
    B.add(new ArrayList<>(Arrays.asList(35, 77)));
    B.add(new ArrayList<>(Arrays.asList(33, 86)));
    B.add(new ArrayList<>(Arrays.asList(2, 50)));
    B.add(new ArrayList<>(Arrays.asList(17, 41)));
    B.add(new ArrayList<>(Arrays.asList(27, 70)));
    B.add(new ArrayList<>(Arrays.asList(7, 43)));
    B.add(new ArrayList<>(Arrays.asList(62, 73)));
    B.add(new ArrayList<>(Arrays.asList(3, 60)));
    B.add(new ArrayList<>(Arrays.asList(49, 58)));
    B.add(new ArrayList<>(Arrays.asList(32, 52)));
    B.add(new ArrayList<>(Arrays.asList(26, 73)));
    B.add(new ArrayList<>(Arrays.asList(13, 78)));
    B.add(new ArrayList<>(Arrays.asList(8, 68)));
    B.add(new ArrayList<>(Arrays.asList(17, 68)));
    B.add(new ArrayList<>(Arrays.asList(34, 51)));
    B.add(new ArrayList<>(Arrays.asList(48, 51)));
    B.add(new ArrayList<>(Arrays.asList(8, 11)));
    B.add(new ArrayList<>(Arrays.asList(31, 78)));
    B.add(new ArrayList<>(Arrays.asList(22, 53)));
    B.add(new ArrayList<>(Arrays.asList(2, 64)));
    B.add(new ArrayList<>(Arrays.asList(71, 80)));
    B.add(new ArrayList<>(Arrays.asList(11, 81)));
    B.add(new ArrayList<>(Arrays.asList(86, 88)));
    B.add(new ArrayList<>(Arrays.asList(9, 67)));
    B.add(new ArrayList<>(Arrays.asList(6, 18)));
    B.add(new ArrayList<>(Arrays.asList(40, 53)));
    B.add(new ArrayList<>(Arrays.asList(52, 77)));
    B.add(new ArrayList<>(Arrays.asList(21, 52)));
    B.add(new ArrayList<>(Arrays.asList(47, 71)));
    B.add(new ArrayList<>(Arrays.asList(48, 50)));
    B.add(new ArrayList<>(Arrays.asList(16, 76)));
    B.add(new ArrayList<>(Arrays.asList(16, 86)));
    B.add(new ArrayList<>(Arrays.asList(3, 71)));
    B.add(new ArrayList<>(Arrays.asList(10, 59)));
    B.add(new ArrayList<>(Arrays.asList(33, 73)));
    B.add(new ArrayList<>(Arrays.asList(52, 68)));
    B.add(new ArrayList<>(Arrays.asList(24, 66)));
    B.add(new ArrayList<>(Arrays.asList(32, 72)));
    B.add(new ArrayList<>(Arrays.asList(3, 4)));
    B.add(new ArrayList<>(Arrays.asList(34, 35)));
    B.add(new ArrayList<>(Arrays.asList(57, 76)));
    B.add(new ArrayList<>(Arrays.asList(25, 33)));
    B.add(new ArrayList<>(Arrays.asList(20, 59)));
    B.add(new ArrayList<>(Arrays.asList(29, 44)));
    B.add(new ArrayList<>(Arrays.asList(50, 56)));
    B.add(new ArrayList<>(Arrays.asList(41, 82)));
    B.add(new ArrayList<>(Arrays.asList(25, 85)));
    B.add(new ArrayList<>(Arrays.asList(17, 35)));
    B.add(new ArrayList<>(Arrays.asList(34, 52)));
    B.add(new ArrayList<>(Arrays.asList(62, 68)));
    B.add(new ArrayList<>(Arrays.asList(5, 26)));
    B.add(new ArrayList<>(Arrays.asList(13, 39)));
    B.add(new ArrayList<>(Arrays.asList(25, 56)));
    B.add(new ArrayList<>(Arrays.asList(5, 12)));
    B.add(new ArrayList<>(Arrays.asList(85, 87)));
    B.add(new ArrayList<>(Arrays.asList(20, 86)));
    B.add(new ArrayList<>(Arrays.asList(63, 80)));
    B.add(new ArrayList<>(Arrays.asList(6, 53)));
    B.add(new ArrayList<>(Arrays.asList(28, 78)));
    B.add(new ArrayList<>(Arrays.asList(47, 65)));
    B.add(new ArrayList<>(Arrays.asList(28, 64)));
    B.add(new ArrayList<>(Arrays.asList(7, 51)));
    B.add(new ArrayList<>(Arrays.asList(41, 59)));
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
      graph[v2].add(new Edge(v2, v1));
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

  private boolean detectCycle(ArrayList<Edge>[] graph, int vertex, boolean[] visited) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(vertex);
    while (!q.isEmpty()) {
      final Integer rem = q.remove();
      if (visited[rem]) {
        return true;
      }
      visited[rem] = true;
      for (Edge edge : graph[rem]) {
        if (!visited[edge.nbr]) {
          q.add(edge.nbr);
        }
      }
    }
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