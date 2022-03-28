package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    int k = 3;
    System.out.println(subarraySum(nums, k));
  }

  public static int subarraySum(int[] nums, int k) {
    int count = 0;
    Map<Integer, Integer> sumOccurrencesMap = new HashMap<>();
    sumOccurrencesMap.put(0, 1);
    int sum = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (sumOccurrencesMap.containsKey(sum - k)) {
        count += sumOccurrencesMap.get(sum - k);
      }
      sumOccurrencesMap.put(sum, sumOccurrencesMap.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
