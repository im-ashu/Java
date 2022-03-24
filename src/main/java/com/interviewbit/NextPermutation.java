package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(
        Arrays.asList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675,
            424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983,
            728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952,
            626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208,
            472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351,
            241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701,
            319, 695, 52));
    nextPermutation(A).stream().map(integer -> integer + " ").forEach(System.out::print);
  }

  public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
    int n = A.size();
    int index1 = -1;
    int index2 = n - 1;
    ArrayList<Integer> res = new ArrayList<>(A);
    for (int i = n - 2; i >= 0; i--) {
      if (A.get(i) < A.get(i + 1)) {
        index1 = i;
        break;
      }
    }
    if (index1 == -1) {
      Collections.reverse(res);
      return res;
    }
    for (int i = n - 1; i >= 0; i--) {
      if (A.get(i) > A.get(index1)) {
        index2 = i;
        break;
      }
    }
    Collections.swap(res, index2, index1);
    int i = index1 + 1;
    int j = n - 1;
    while (i < j) {
      Collections.swap(res, i, j);
      i++;
      j--;
    }
    return res;
  }
}