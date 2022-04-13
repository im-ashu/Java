package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDifferenceTwoArrays {

  public static void main(String[] args) {
    FindDifferenceTwoArrays findDifferenceTwoArrays = new FindDifferenceTwoArrays();
    int[] nums1 = {1, 2, 3, 3};
    int[] nums2 = {1, 1, 2, 2};
    List<List<Integer>> difference = findDifferenceTwoArrays.findDifference(nums1, nums2);
    for (List<Integer> integers : difference) {
      for (Integer integer : integers) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    res.add(new ArrayList<>());
    s1.stream().mapToInt(n -> n).filter(n -> !s2.contains(n)).forEach(n -> res.get(0).add(n));
    s2.stream().mapToInt(n -> n).filter(n -> !s1.contains(n)).forEach(n -> res.get(1).add(n));
    return res;
  }
}
