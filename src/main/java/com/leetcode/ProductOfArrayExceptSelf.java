package com.leetcode;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
    int[] nums = {-1, 1, 0, -3, 3};
    int[] productExceptSelf = product.productExceptSelf(nums);
    for (int j : productExceptSelf) {
      System.out.print(j + " ");
    }

  }

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefixProduct = new int[n + 1];
    prefixProduct[0] = 1;
    for (int i = 1; i < n + 1; i++) {
      prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
    }
    int[] suffixProduct = new int[n + 1];
    suffixProduct[n] = 1;
    for (int i = n - 1; i >= 0; i--) {
      suffixProduct[i] = suffixProduct[i + 1] * nums[i];
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = prefixProduct[i] * suffixProduct[i + 1];
    }
    return result;
  }

}
