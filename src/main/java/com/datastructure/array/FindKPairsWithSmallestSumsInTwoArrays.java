package com.datastructure.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import org.javatuples.Pair;
import org.javatuples.Triplet;

public class FindKPairsWithSmallestSumsInTwoArrays {

  private static Queue<Triplet<Integer, Integer, Integer>> priorityQueue = new PriorityQueue<>(
      Comparator.comparing(Triplet::getValue0));
  private static Set<Pair<Integer, Integer>> set = new HashSet<>();

  public static void main(String[] args) {
    int[] arr1 = {11, 1, 3};
    int n1 = arr1.length;
    int[] arr2 = {8, 4, 2};
    int n2 = arr2.length;
    int k = 4;
    kSmallestPair(arr1, n1, arr2, n2, k);
  }

  private static void kSmallestPair(int[] arr1, int n1, int[] arr2, int n2, int k) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    if (k > n1 * n2) {
      System.out.println("K pairs don't exits");
      return;
    }

    priorityQueue.add(makeTriplet(arr1[0] + arr2[0], 0, 0));
    set.add(makePair(0, 0));

    for (int count = 0; count < k; count++) {
      Triplet<Integer, Integer, Integer> temp = priorityQueue.poll();
      int i = temp.getValue1();
      int j = temp.getValue2();
      System.out.printf("(%d,%d)%n", arr1[i], arr2[j]);
      int sum = arr1[i + 1] + arr2[j];
      updatePriorityQueue(i + 1, j, sum);
      sum = arr1[i] + arr2[j + 1];
      updatePriorityQueue(i, j + 1, sum);
    }

  }

  private static void updatePriorityQueue(int i, int j, int sum) {
    if (!set.contains(makePair(i, j))) {
      priorityQueue.add(makeTriplet(sum, i, j));
      set.add(makePair(i, j));
    }
  }

  private static Pair<Integer, Integer> makePair(Integer i, Integer j) {
    return new Pair<>(i, j);
  }

  private static Triplet<Integer, Integer, Integer> makeTriplet(Integer i, Integer j, Integer k) {
    return new Triplet<>(i, j, k);
  }

}
