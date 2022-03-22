package com.datastructure.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);
    System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
    graph.breadthFirstSearch(2);
    System.out.println();
  }

  static class Graph {

    private final int noOfVertices;
    private final List<List<Integer>> adj;

    public Graph(int noOfVertices) {
      this.noOfVertices = noOfVertices;
      adj = new LinkedList<>();
      for (int i = 0; i < noOfVertices; i++) {
        adj.add(new LinkedList<>());
      }
    }

    public void addEdge(int v, int w) {
      adj.get(v).add(w);
    }

    public void breadthFirstSearch(int source) {
      Queue<Integer> queue = new LinkedList<>();
      boolean[] visited = new boolean[noOfVertices];
      visited[source] = true;
      queue.add(source);
      while (!queue.isEmpty()) {
        int element = queue.poll();
        System.out.printf("%d ", element);
        for (Integer adjacentEdge : adj.get(element)) {
          if (!visited[adjacentEdge]) {
            visited[adjacentEdge] = true;
            queue.add(adjacentEdge);
          }
        }
      }
    }
  }

}
