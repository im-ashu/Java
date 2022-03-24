package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaximalRectangle {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    A.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 0, 0)));
    final MaximalRectangle maximalRectangle = new MaximalRectangle();
    System.out.println(maximalRectangle.maximalRectangle(A));
  }

  public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
    int col = A.get(0).size();
    int[] arr = new int[col];
    int maxArea = Integer.MIN_VALUE;
    for (ArrayList<Integer> numbers : A) {
      int index = 0;
      for (Integer number : numbers) {
        if (number == 1) {
          arr[index++] += 1;
        } else {
          arr[index++] = 0;
        }
      }
      int area = mah(arr);
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }

  private int mah(int[] arr) {
    int n = arr.length;
    final ArrayList<Integer> nsl = generateNSL(arr);
    final ArrayList<Integer> nsr = generateNSR(arr);
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxArea = Math.max(maxArea, (nsr.get(i) - nsl.get(i) - 1) * arr[i]);
    }
    return maxArea;
  }

  private ArrayList<Integer> generateNSL(int[] arr) {
    ArrayList<Integer> ans = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }
      ans.add(s.empty() ? -1 : s.peek());
      s.push(i);
    }
    return ans;
  }

  private ArrayList<Integer> generateNSR(int[] arr) {
    ArrayList<Integer> ans = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    int n = arr.length;
    for (int i = n - 1; i >= 0; i--) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }
      ans.add(s.empty() ? n : s.peek());
      s.push(i);
    }
    Collections.reverse(ans);
    return ans;
  }
}