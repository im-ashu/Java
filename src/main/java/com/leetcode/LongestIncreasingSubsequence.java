package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 4, 7};
    System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    System.out.println(new LongestIncreasingSubsequence().lengthOfLISII(nums));
    System.out.println(new LongestIncreasingSubsequence().lengthOfLISIII(nums));
  }

  public int lengthOfLIS(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    List<Integer> sortedList = new ArrayList<>(set);
    int n = nums.length;
    int m = sortedList.size();
    int[][] t = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (sortedList.get(j - 1) == nums[i - 1]) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    return t[n][m];
  }

  public int lengthOfLISII(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
      int num = nums[i];
      Integer ceiling = set.ceiling(num);
      if (ceiling != null) {
        set.remove(ceiling);
      }
      set.add(num);
    }
    return set.size();
  }

  public int lengthOfLISIII(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return 1;
    }
    int[] t = new int[n];
    int omax = 1;
    for (int i = 0; i < n; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && t[j] > max) {
          max = t[j];
        }
      }
      t[i] = 1 + max;
      omax = Math.max(t[i], omax);
    }
    return omax;
  }
}