package com.leetcode;

public class NextPermutation {

  public static void main(String[] args) {
    int[] nums = {1, 3, 2};
    nextPermutation(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  public static void nextPermutation(int[] nums) {
    int n = nums.length;
    int index1 = -1;
    int index2 = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        index1 = i;
        break;
      }
    }
    if (index1 == -1) {
      reverse(nums, 0, n - 1);
      return;
    }
    for (int i = n - 1; i >= 0; i--) {
      if (nums[index1] < nums[i]) {
        index2 = i;
        break;
      }
    }
    swap(nums, index1, index2); //1 4 5 3 2
    reverse(nums, index1 + 1, n - 1);
  }

  public static void reverse(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}