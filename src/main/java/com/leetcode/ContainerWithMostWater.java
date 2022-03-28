package com.leetcode;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    ContainerWithMostWater c = new ContainerWithMostWater();
    int[] height = {1, 1};
    System.out.println(c.area(height));
  }

  private int area(int[] height) {
    int n = height.length;
    int l = 0;
    int r = n - 1;
    int area = Integer.MIN_VALUE;
    while (l < r) {
      area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return area;
  }

}