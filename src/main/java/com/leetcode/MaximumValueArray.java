package com.leetcode;

import java.util.HashMap;

public class MaximumValueArray {

  public static void main(String[] args) {
    MaximumValueArray maximumValueArray = new MaximumValueArray();
    int[] numbers = {2, 1, 2, 3, 3};
    int k = 3;
    System.out.println(maximumValueArray.mva(numbers, k));

  }

  private int mva(int[] numbers, int k) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    int n = numbers.length;
    int begin = 0, end = 0;
    int maxValue = Integer.MIN_VALUE;
    int windowMax = 0;
    while (end < n) {
      frequencyMap.put(numbers[end], frequencyMap.getOrDefault(numbers[end], 0) + 1);
      int freq = frequencyMap.get(numbers[end]);
      int toAdd = numbers[end];
      if (freq > 1) {
        toAdd = (int) (Math.pow(numbers[end], freq) - Math.pow(numbers[end], freq - 1));
      }
      windowMax += toAdd;
      if (end - begin + 1 == k) {
        maxValue = Math.max(maxValue, windowMax);
      } else if (end - begin + 1 > k) {
        int numberAtBegin = numbers[begin];
        int toSub;
        if (frequencyMap.containsKey(numberAtBegin)) {
          frequencyMap.put(numberAtBegin, frequencyMap.get(numberAtBegin) - 1);
        }
        if (frequencyMap.get(numberAtBegin) > 1) {
          toSub = (int) (Math.pow(numbers[end], freq - 1) - Math.pow(numbers[end], freq));
        } else {
          toSub = -1 * numberAtBegin;
        }
        windowMax += toSub;
        maxValue = Math.max(maxValue, windowMax);
        begin++;
      }
      end++;
    }
    return maxValue;
  }
}