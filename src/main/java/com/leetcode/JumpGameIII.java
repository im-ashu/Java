package com.leetcode;

public class JumpGameIII {

  public static void main(String[] args) {
    int[] arr = {3, 0, 2, 1, 2};
    int start = 2;
    System.out.println(new JumpGameIII().canReach(arr, start));
  }

  private boolean canReach(int[] arr, int start) {
    if (start >= 0 && start < arr.length && arr[start] >= 0) {
      if (arr[start] == 0) {
        return true;
      }
      int temp = arr[start];
      arr[start] = -arr[start];
      boolean reach = canReach(arr, start + temp) || canReach(arr, start - temp);
      arr[start] = temp;
      return reach;
    }
    return false;
  }
}