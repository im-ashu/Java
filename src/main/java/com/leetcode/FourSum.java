package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public static void main(String[] args) {
    FourSum fourSum = new FourSum();
    int[] nums = {2, 2, 2, 2, 2};
    int target = 8;
    List<List<Integer>> result = fourSum.fourSum(nums, target);
    for (List<Integer> quadruplet : result) {
      System.out.print("[");
      for (Integer n : quadruplet) {
        System.out.print(" " + n + " ");
      }
      System.out.print("]");
    }

  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n - 2; j++) {
        int left = j + 1;
        int right = n - 1;
        int sum = nums[i] + nums[j];
        int rem = target - sum;
        while (left < right) {
          if (nums[left] + nums[right] == rem) {
            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            while (left < right && nums[left] == result.get(result.size() - 1).get(2)) {
              left++;
            }
            while (left < right && nums[right] == result.get(result.size() - 1).get(3)) {
              right--;
            }
          } else if ((nums[left] + nums[right]) > rem) {
            right--;
          } else {
            left++;
          }
        }
        while (j < n - 1 && nums[j] == nums[j + 1]) {
          j++;
        }
        while (i < n - 1 && nums[i] == nums[i + 1]) {
          i++;
        }
      }
    }
    return result;
  }
}
