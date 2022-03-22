package com.datastructure.disjointset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {

  public static void main(String[] args) {
    String s = "dcab";
    List<List<Integer>> pairs = new ArrayList<>();
    pairs.add(new ArrayList<>(Arrays.asList(0, 3)));
    pairs.add(new ArrayList<>(Arrays.asList(1, 2)));
    System.out.println(smallestStringWithSwaps(s, pairs));
  }

  public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    int n = s.length();
    if (pairs.isEmpty()) {
      return s;
    }
    UnionFind u = new UnionFind(n);
    for (List<Integer> p : pairs) {
      u.union(p.get(0), p.get(1));
    }
    Map<Integer, PriorityQueue<Character>> m = new HashMap<>();
    for (int i = 0; i < n; i++) {
      final int head = u.find(i);
      if (!m.containsKey(head)) {
        m.put(head, new PriorityQueue<>());
      }
      m.get(head).add(s.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(m.get(u.find(i)).poll());
    }
    return sb.toString();
  }
}