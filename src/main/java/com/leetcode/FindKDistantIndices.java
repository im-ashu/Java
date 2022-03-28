package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FindKDistantIndices {

  public static void main(String[] args) {
    int[] nums = {2, 2, 2, 2, 2};
    int key = 2;
    int k = 2;
    List<Integer> kDistantIndices = new FindKDistantIndices().findKDistantIndices(nums, key, k);
    for (Integer distantIndex : kDistantIndices) {
      System.out.print(distantIndex + " ");
    }

  }

  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    int n = nums.length;
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (nums[i] == key) {
          if (Math.abs(i - j) <= k) {
            set.add(j);
          }
        }
      }
    }
    return new ArrayList<>(set);
  }
}