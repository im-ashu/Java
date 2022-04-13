package com.leetcode;

public class CapacityToShipPackagesWithinDDays {

  public static void main(String[] args) {
    CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
    int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int days = 1;
    System.out.println(capacityToShipPackagesWithinDDays.shipWithinDays(weights, days));
  }

  public int shipWithinDays(int[] weights, int days) {
    int res = 0;
    int left = 0;
    int right = 0;
    for (int weight : weights) {
      left = Math.max(weight, left);
      right += weight;
    }

    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (isPossible(weights, mid, days)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean isPossible(int[] weights, int capacity, int days) {
    int currentCapacity = 0;
    int daysNeeded = 1;
    for (int weight : weights) {
      if (currentCapacity + weight > capacity) {
        currentCapacity = weight;
        daysNeeded++;
        if (daysNeeded > days) {
          return false;
        }
      } else {
        currentCapacity += weight;
      }
    }
    return true;
  }
}
