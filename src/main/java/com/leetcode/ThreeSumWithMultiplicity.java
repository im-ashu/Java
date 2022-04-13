package com.leetcode;

import java.util.HashMap;

public class ThreeSumWithMultiplicity {

  public static void main(String[] args) {
    ThreeSumWithMultiplicity threeSumWithMultiplicity = new ThreeSumWithMultiplicity();
    int[] arr = {5, 5, 1, 1, 2, 2, 3, 4, 3, 4};
    int target = 8;
    System.out.println(threeSumWithMultiplicity.threeSumMulti(arr, target));
  }

  public int threeSumMulti(int[] arr, int target) {
    int count = 0;
    int modulo = (int) (1e9 + 7);
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int rem = target - arr[i];
      for (int j = i + 1; j < n; j++) {
        int nestedRem = rem - arr[j];
        if (map.containsKey(nestedRem)) {
          count += map.get(nestedRem);
          count %= modulo;
        }
        map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
      }
    }
    return count;
  }
}
