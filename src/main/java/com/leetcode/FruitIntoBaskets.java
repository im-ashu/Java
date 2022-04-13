package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

  public static void main(String[] args) {
    FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
    int[] fruits = {0, 1, 2, 2};
    System.out.println(fruitIntoBaskets.totalFruit(fruits));
  }

  public int totalFruit(int[] fruits) {
    int end = 0;
    int begin = 0;
    int counter = 0;
    int n = fruits.length;
    int maxFruits = 0;
    Map<Integer, Integer> windowFreq = new HashMap<>();
    while (end < n) {
      int eFruit = fruits[end];
      windowFreq.put(eFruit, windowFreq.getOrDefault(eFruit, 0) + 1);
      if (windowFreq.get(eFruit) == 1) {
        counter++;
      }
      while (counter > 2) {
        int bFruit = fruits[begin];
        if (windowFreq.containsKey(bFruit)) {
          windowFreq.put(bFruit, windowFreq.get(bFruit) - 1);
          if (windowFreq.get(bFruit) == 0) {
            counter--;
          }
        }
        begin++;
      }
      if (counter == 2) {
        maxFruits = Math.max(maxFruits, end - begin + 1);
      }
      end++;
    }
    return maxFruits;
  }
}
