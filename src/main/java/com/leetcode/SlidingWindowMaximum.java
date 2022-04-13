package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindowMaximum {

  public static void main(String[] args) {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    int[] nums = {1};
    int k = 1;
    int[] maxSlidingWindow = slidingWindowMaximum.maxSlidingWindow(nums, k);
    Arrays.stream(maxSlidingWindow).mapToObj(e -> e + " ").forEach(System.out::print);
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    ArrayList<Integer> res = new ArrayList<>();
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int end = 0;
    int begin = 0;
    int n = nums.length;
    while (end < n) {
      while (!queue.isEmpty() && queue.peekLast() < nums[end]) {
        queue.removeLast();
      }
      queue.addLast(nums[end]);
      if (!queue.isEmpty() && end - begin + 1 == k) {
        Integer queueFirst = queue.peekFirst();
        res.add(queueFirst);
        if (queueFirst == nums[begin]) {
          queue.removeFirst();
        }
        begin++;
      }
      end++;
    }
    return res.stream().mapToInt(e -> e).toArray();
  }
}
