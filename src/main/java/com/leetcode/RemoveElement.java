package com.leetcode;

public class RemoveElement {

  public static void main(String[] args) {
    RemoveElement r = new RemoveElement();
    int[] nums = {3, 2, 2, 3};
    int val = 2;
    System.out.println(r.removeElement(nums, val));
  }

  public int removeElement(int[] nums, int val) {
    int n = nums.length;
    if (n == 0 || n == 1) {
      return n;
    }
    int l = 0;
    int r = n - 1;
    int count = 0;
    while (l < r) {
      if (nums[l] == val) {
        swap(nums, l, r);
        r--;
      } else {
        l++;
      }
    }
    return l;
  }

  private void swap(int[] nums, int l, int r) {
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;
  }
}