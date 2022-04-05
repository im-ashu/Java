package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

  public static void main(String[] args) {
    LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
    int[] nums = {100, 4, 200, 1, 3, 2};
    System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
  }

  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = Arrays.stream(nums).boxed()
        .collect(Collectors.toCollection(HashSet::new));

    int maxLength = 0;
    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int length = 1;
        int currentNum = num;
        while (set.contains(currentNum + 1)) {
          length += 1;
          currentNum += 1;
        }
        maxLength = Math.max(maxLength, length);
      }
    }
    return maxLength;
  }
}
