package com.datastructure.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class SubArraysMax {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(
        Arrays.asList(648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81,
            807, 578, 712, 951, 867, 328, 308, 440, 542,
            178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36,
            705, 900, 482, 558, 937, 207, 368));
    ArrayList<Integer> Result = new ArrayList<>(
        Arrays.asList(745, 745, 775, 775, 876, 876, 876, 876, 876, 876, 876, 951, 951, 951, 951,
            951, 951, 951, 951, 951, 882, 882, 882, 882, 935, 935, 935, 935, 935,
            935, 935, 935, 935, 892, 892, 892, 900, 900, 900, 937, 937, 937));
    int K = 9;
    final ArrayList<Integer> output = subArraysMax(A, K);
    // output.stream().map(e -> e + " ").forEach(System.out::println);
    for (int i = 0; i < output.size(); i++) {
      if (!Objects.equals(Result.get(i), output.get(i))) {
        System.out.println(
            "Difference : Expected = " + Result.get(i) + " Actual = " + output.get(i));
      }
    }

  }

  private static ArrayList<Integer> subArraysMax(final List<Integer> A, int B) {
    int i = 0, j = 0;
    Deque<Integer> q = new ArrayDeque<>();
    int N = A.size();
    ArrayList<Integer> res = new ArrayList<>();
    while (j < N) {
      while (!q.isEmpty() && q.peekLast() < A.get(j)) {
        q.removeLast();
      }
      q.addLast(A.get(j));
      if (j - i + 1 == B) {
        res.add(q.peekFirst());
        if (Objects.equals(q.peekFirst(), A.get(i))) {
          q.removeFirst();
        }
        i++;
      }
      j++;
    }
    return res;
  }
}