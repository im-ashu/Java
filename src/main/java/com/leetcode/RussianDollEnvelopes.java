package com.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class RussianDollEnvelopes {

  public static void main(String[] args) {
    int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
    System.out.println(new RussianDollEnvelopes().maxEnvelopesII(envelopes));
  }

  public int maxEnvelopes(int[][] envelopes) {//O(N^2)
    int n = envelopes.length;
    int[] t = new int[n];
    Arrays.sort(envelopes, (arr1, arr2) -> {
      if (arr1[0] == arr2[0]) {
        return arr2[1] - arr1[1];
      } else {
        return arr1[0] - arr2[0];
      }
    });
    int len = 0;
    for (int i = 0; i < n; i++) {
      int index = Arrays.binarySearch(t, 0, len, envelopes[i][1]);
      if (index < 0) {
        index = -(index + 1);
      }
      t[index] = envelopes[i][1];
      if (index == len) {
        len++;
      }
    }
    return len;
  }

  public int maxEnvelopesII(int[][] envelopes) {//O(NlogN)
    int n = envelopes.length;
    Arrays.sort(envelopes, (arr1, arr2) -> {
      if (arr1[0] == arr2[0]) {
        return arr2[1] - arr1[1];
      } else {
        return arr1[0] - arr2[0];
      }
    });
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      Integer ceiling = set.ceiling(envelopes[i][1]);
      if (ceiling != null) {
        set.remove(ceiling);
      }
      set.add(envelopes[i][1]);
    }
    return set.size();
  }
}
