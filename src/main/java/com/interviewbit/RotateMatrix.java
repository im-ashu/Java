package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {

  public static void main(String[] args) {
    final ArrayList<Integer> firstRow = new ArrayList<>(Arrays.asList(1, 2));
    final ArrayList<Integer> secondRow = new ArrayList<>(Arrays.asList(3, 4));
    ArrayList<ArrayList<Integer>> a = new ArrayList<>(Arrays.asList(firstRow, secondRow));
    rotate(a);
    reverseRows(a);
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.get(i).size(); j++) {
        System.out.print(a.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  public static void rotate(ArrayList<ArrayList<Integer>> a) {
    for (int i = 0; i < a.size(); i++) {
      for (int j = i; j < a.get(i).size(); j++) {
        int temp = a.get(j).get(i);
        a.get(j).set(i, a.get(i).get(j));
        a.get(i).set(j, temp);
      }
    }
  }

  static void reverseRows(ArrayList<ArrayList<Integer>> a) {
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0, k = a.get(0).size() - 1; j < k;
          j++, k--) {
        int temp = a.get(i).get(j);
        a.get(i).set(j, a.get(i).get(k));
        a.get(i).set(k, temp);
      }
    }
  }
}