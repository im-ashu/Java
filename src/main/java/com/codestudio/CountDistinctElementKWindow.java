package com.codestudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountDistinctElementKWindow {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 2, 3));
    int k = 4;
    ArrayList<Integer> result = countDistinctElements(arr, k);
    System.out.println(result);
  }

  public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

    // Write your code here
    int begin = 0;
    int end = 0;
    int n = arr.size();
    ArrayList<Integer> result = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    while (end < n) {
      int e = arr.get(end);
      map.put(e, map.getOrDefault(e, 0) + 1);
      if (end - begin + 1 > k) {
        int b = arr.get(begin);
        if (map.containsKey(b)) {
          map.put(b, map.get(b) - 1);
          if (map.get(b) == 0) {
            map.remove(b);
          }
        }
        begin++;
      }
      if (end - begin + 1 == k) {
        result.add(map.size());
      }
      end++;
    }
    return result;
  }
}