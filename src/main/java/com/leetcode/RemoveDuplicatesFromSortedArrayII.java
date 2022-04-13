package com.leetcode;

import java.util.stream.IntStream;

public class RemoveDuplicatesFromSortedArrayII {

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
    int[] nums = {1, 1, 1, 2, 2, 3};
    int newArraySize = removeDuplicatesFromSortedArrayII.removeDuplicates(nums);
    IntStream.range(0, newArraySize).mapToObj(i -> nums[i] + " ").forEach(System.out::print);
  }

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    int count = 1;
    int index = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[index++] = nums[i];
        count = 1;
      } else {
        if (count < 2) {
          count++;
          nums[index++] = nums[i];
        }
      }
    }
    return index;
  }
}
