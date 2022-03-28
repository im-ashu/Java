package com.leetcode;

public class CanPlaceFlowers {

  public static void main(String[] args) {
    int[] flowerbed = {1};
    int n = 0;
    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, n));
    System.out.println(Math.pow(-10, 5) > Integer.MIN_VALUE);
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    int m = flowerbed.length;
    if (m == 1) {
      return n <= m && flowerbed[0] == 0;
    }
    for (int i = 0; i < m; i++) {
      if (i > 0 && i < m - 1) {
        if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
          count++;
          i++;
          if (count > n) {
            return true;
          }
        }
      } else if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
        count++;
        i++;
        if (count > n) {
          return true;
        }
      } else if (i == m - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
        count++;
        i++;
        if (count > n) {
          return true;
        }
      }
    }
    return count == n;
  }
}