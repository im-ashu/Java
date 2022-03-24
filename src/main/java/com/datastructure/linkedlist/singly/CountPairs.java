package com.datastructure.linkedlist.singly;

import java.util.HashSet;
import java.util.LinkedList;

public class CountPairs {

  public static void main(String[] args) {
    LinkedList<Integer> list1 = new LinkedList<>();
    list1.add(7);
    list1.add(5);
    list1.add(1);
    list1.add(3);
    LinkedList<Integer> list2 = new LinkedList<>();
    list2.add(3);
    list2.add(5);
    list2.add(2);
    list2.add(8);
    System.out.println(countPairs(list1, list2, 10));

  }

  public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
      int x) {
    // add your code here
    int count = 0;
    HashSet<Integer> set = new HashSet<>(head1);
    for (int number : head2) {
      if (set.contains(x - number)) {
        count++;
      }
    }
    return count;
  }
}