package com.leetcode;

public class TwoFurthestHousesWithDifferentColors {

  public static void main(String[] args) {
    TwoFurthestHousesWithDifferentColors houses = new TwoFurthestHousesWithDifferentColors();
    int[] colors = {4, 4, 4, 11, 4, 4, 11, 4, 4, 4, 4, 4};
    System.out.println(houses.maxDistance(colors));
  }

  public int maxDistance(int[] colors) {
    int n = colors.length;
    int first = colors[0];
    int last = colors[n - 1];
    int right = n - 1;
    int res = 0;
    while (right >= 0) {
      if (colors[right] != first) {
        res = Math.max(right, res);
      }
      if (colors[right] != last) {
        res = Math.max(n - right - 1, res);
      }
      right--;
    }
    return res;
  }
}
