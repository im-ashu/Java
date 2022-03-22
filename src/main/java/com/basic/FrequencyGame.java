package com.basic;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class FrequencyGame {

  public static void main(String[] args) {
    int[] arr = {2, 2, 5, 50, 50, 1};
    arr = new int[]{1};
    int n = arr.length;
    System.out.println(LargButMinFreq(arr, n));
  }

  public static int LargButMinFreq(int[] arr, int n) {
    // Your code here
    TreeMap<Integer, TreeSet<Integer>> freqKeyNumberSet = new TreeMap<>();
    TreeMap<Integer, Integer> numberKeyFreq = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      Integer freqOfNumber = numberKeyFreq.getOrDefault(arr[i], 0);
      TreeSet<Integer> oldFreqSet = freqKeyNumberSet.getOrDefault(freqOfNumber, new TreeSet<>());
      oldFreqSet.remove(arr[i]);
      TreeSet<Integer> newFreqSet = freqKeyNumberSet.getOrDefault(freqOfNumber + 1,
          new TreeSet<>());
      newFreqSet.add(arr[i]);
      freqKeyNumberSet.put(freqOfNumber + 1, newFreqSet);
      numberKeyFreq.put(arr[i], freqOfNumber + 1);
    }
    freqKeyNumberSet.remove(0);
    Map.Entry<Integer, TreeSet<Integer>> minFreqNumbersEntry = freqKeyNumberSet.firstEntry();
    return minFreqNumbersEntry.getValue().last();
  }
}