package com.leetcode;

public class MergeSortedArray {

  public static void main(String[] args) {
    MergeSortedArray mergeSortedArray = new MergeSortedArray();
    int[] nums1 = {4, 0, 0, 0, 0, 0};
    int[] nums2 = {1, 2, 3, 5, 6};
    int m = 1;
    int n = 5;
    mergeSortedArray.merge(nums1, m, nums2, n);
    for (int i : nums1) {
      System.out.print(i + " ");
    }

  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (m == 0) {
      System.arraycopy(nums2, 0, nums1, m, n);
      return;
    }
    if (n == 0) {
      return;
    }
    for (int i = 0; i < m; i++) {
      if (nums1[i] > nums2[0]) {
        int temp = nums1[i];
        nums1[i] = nums2[0];
        nums2[0] = temp;

        int first = nums2[0];
        int k;
        for (k = 1; k < n && nums2[k] < first; k++) {
          nums2[k - 1] = nums2[k];
        }
        nums2[k - 1] = first;
      }
    }
    System.arraycopy(nums2, 0, nums1, m, n);
  }


}
