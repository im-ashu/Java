package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums {

  public static void main(String[] args) {
    FindKPairsSmallestSums findKPairsSmallestSums = new FindKPairsSmallestSums();
    int[] nums1 = {1, 1, 2};
    int[] nums2 = {1, 3};
    int k = 9530;
    List<List<Integer>> lists = findKPairsSmallestSums.kSmallestPairs(nums1, nums2, k);
    for (List<Integer> list : lists) {
      for (Integer integer : list) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
    int x1;
    int x2;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < m && n != 0; i++) {
      minHeap.add(new int[]{nums1[i], nums2[0], 0});
    }
    while (minHeap.size() != 0 && k > 0) {
      int[] rem = minHeap.poll();
      x1 = rem[0];
      x2 = rem[1];
      int index = rem[2];
      k--;
      ArrayList<Integer> subList = new ArrayList<>();
      subList.add(x1);
      subList.add(x2);
      res.add(subList);
      if (index == n - 1) {
        continue;
      }
      minHeap.offer(new int[]{x1, nums2[index + 1], index + 1});
    }
    return res;
  }
}
