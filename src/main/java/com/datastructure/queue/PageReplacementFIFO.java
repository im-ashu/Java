package com.datastructure.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PageReplacementFIFO {

  public static void main(String[] args) {
    int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
    int capacity = 4;
    System.out.println(pageFaults(pages, capacity));
  }

  private static int pageFaults(int[] pages, int capacity) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    int pageFaults = 0;
    for (int page : pages) {
      if (set.size() < capacity) {
        if (!set.contains(page)) {
          pageFaults++;
          queue.offer(page);
          set.add(page);
        }
      } else {
        if (!set.contains(page)) {
          pageFaults++;
          int lastPage = queue.poll();
          set.remove(lastPage);
          queue.offer(page);
          set.add(page);
        }
      }
    }
    return pageFaults;
  }
}
