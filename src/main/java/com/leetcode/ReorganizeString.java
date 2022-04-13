package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {

  public static void main(String[] args) {
    String s = "abbc";
    int k = 2;
    System.out.println(new ReorganizeString().reorganizeString(s, k));
  }

  public String reorganizeString(String str, int k) {
    if (str == null || str.length() == 0) {
      return "";
    }
    int n = str.length();
    if (n == 1) {
      return str;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
    }
    PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    pq.addAll(map.keySet());
    StringBuilder res = new StringBuilder();
    Queue<Character> q = new LinkedList<>();
    while (!pq.isEmpty()) {
      Character remCh = pq.poll();
      res.append(remCh);
      map.put(remCh, map.get(remCh) - 1);
      q.add(remCh);
      while (q.size() > 1) {
        Character ch = q.poll();
        if (map.get(ch) > 0) {
          pq.add(ch);
        }
      }
    }
    return res.length() == str.length() ? res.toString() : "NO SOLUTION";
  }
}