package com.gfg;// { Driver Code Starts

import java.util.ArrayList;

public class SubArraySum {

  public static void main(String[] args) {
    int t = 1;

    for (int i = 0; i < t; i++) {
      int[] m = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37,
          192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139,
          70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
      int n = m.length;
      int s = 468;

      ArrayList<Integer> res = subarraySum(m, n, s);
      for (Integer re : res) {
        System.out.print(re + " ");
      }
      System.out.println();
    }
  }

  //Function to find a continuous sub-array which adds up to a given number.
  static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
    ArrayList<Integer> ans = new ArrayList<>();
    int begin = 0, end = 0;
    int windowSum = 0;
    while (end < n) {
      windowSum += arr[end];
      if (windowSum == s) {
        ans.add(begin + 1);
        ans.add(end + 1);
        return ans;
      } else if (windowSum > s) {
        while (windowSum > s) {
          windowSum -= arr[begin];
          begin++;
          if (windowSum == s) {
            ans.add(begin + 1);
            ans.add(end + 1);
            return ans;
          }
        }
      }
      end++;
    }
    ans.add(-1);
    return ans;
  }
}