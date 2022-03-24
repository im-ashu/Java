package com.datastructure.recursion;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class JosephusProblem {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    int n = 40;
    int k = 7;
    IntStream.range(1, n + 1).forEach(arr::add);
    System.out.println(josephus(arr, 0, k - 1));
  }

  private static int josephus(ArrayList<Integer> arr, int index, int k) {
    if (arr.size() == 1) {
      return arr.get(0);
    }
    index = (index + k) % arr.size();
    arr.remove(index);
    return josephus(arr, index, k);
  }
}