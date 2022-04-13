package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

  public static void main(String[] args) {
    TaskScheduler taskScheduler = new TaskScheduler();
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    int n = 2;
    System.out.println(taskScheduler.leastInterval(tasks, n));
  }

  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> occurrencesMap = new HashMap<>();
    for (char task : tasks) {
      occurrencesMap.put(task, occurrencesMap.getOrDefault(task, 0) + 1);
    }
    PriorityQueue<Character> maxHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(occurrencesMap.get(b), occurrencesMap.get(a)));
    int result = 0;
    maxHeap.addAll(occurrencesMap.keySet());
    while (!maxHeap.isEmpty()) {
      int k = n + 1;
      Queue<Character> queue = new LinkedList<>();
      while (k > 0 && !maxHeap.isEmpty()) {
        Character character = maxHeap.poll();
        occurrencesMap.put(character, occurrencesMap.get(character) - 1);
        queue.add(character);
        result++;
        k--;
      }
      while (queue.size() > 0) {
        Character ch = queue.poll();
        if (occurrencesMap.get(ch) > 0) {
          maxHeap.add(ch);
        }
      }
      if (maxHeap.isEmpty()) {
        break;
      }
      result += k;
    }
    return result;
  }
}
