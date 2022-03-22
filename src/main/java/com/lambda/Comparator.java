package com.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Comparator {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(10, 9, 11, 5, 7);
//    Collections.sort(list, ((o1, o2) -> {
//      if (o1 > o2) {
//        return 1;
//      }else if(o1 < o2){
//        return -1;
//      }
//      return 0;
//    }));
    System.out.printf("Elements before sorting : %s%n", list);
    Collections.sort(list, Integer::compareTo);
    System.out.printf("Elements after sorting : %s%n", list);

    System.out.println();
    TreeSet<Integer> treeSet = new TreeSet<>((Integer::compareTo));
    treeSet.add(10);
    treeSet.add(9);
    treeSet.add(11);
    treeSet.add(5);
    treeSet.add(7);
    System.out.printf("Elements of tree set after sorting : %s%n", treeSet);

  }

}
