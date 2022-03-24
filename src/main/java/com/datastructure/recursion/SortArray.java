package com.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class SortArray {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(-1);
    list.add(0);
    list.add(5);
    list.add(2);
    sort(list);
    list.forEach(i -> System.out.print(i + " "));
  }

  private static void sort(List<Integer> list) {
    if (list.size() == 1) {
      return;
    }
    int lastEle = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    sort(list);
    insert(list, lastEle);
  }

  private static void insert(List<Integer> list, int lastEle) {
    if (list.isEmpty() || list.get(list.size() - 1) <= lastEle) {
      list.add(lastEle);
      return;
    }
    int val = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    insert(list, lastEle);
    list.add(val);
  }
}