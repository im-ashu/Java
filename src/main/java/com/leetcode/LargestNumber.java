package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

  public static void main(String[] args) {
    int[] nums = {3, 30, 34, 5, 9};
    System.out.println(new LargestNumber().largestNumber(nums));
  }

  public String largestNumber(int[] nums) {
    int n = nums.length;
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(s, new LargerNumberComparator());
    Arrays.stream(s).forEach(System.out::println);
    if ("0".equalsIgnoreCase(s[0])) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    Arrays.stream(s).forEach(sb::append);
    return sb.toString();
  }

  private class LargerNumberComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      String order1 = o1 + o2;
      String order2 = o2 + o1;
      return order2.compareTo(order1);
    }
  }
}