package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    int[] heights = {2, 1, 5, 6, 2, 3};
    LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
    System.out.println(largestRectangleInHistogram.largestRectangleArea(heights));
  }

  private int largestRectangleArea(int[] heights) {
    ArrayList<Integer> nsl = nsl(heights);
    ArrayList<Integer> nsr = nsr(heights);
    int maxArea = 0;
    for (int i = 0, n = heights.length; i < n; i++) {
      int area = (nsr.get(i) - nsl.get(i) - 1) * heights[i];
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }

  private ArrayList<Integer> nsl(int[] temp) {
    ArrayList<Integer> nsl = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0, n = temp.length; i < n; i++) {
      while (!stack.isEmpty() && temp[stack.peek()] >= temp[i]) {
        stack.pop();
      }
      nsl.add(stack.isEmpty() ? -1 : stack.peek());
      stack.add(i);
    }
    return nsl;
  }

  private ArrayList<Integer> nsr(int[] temp) {
    ArrayList<Integer> nsr = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    int n = temp.length;
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temp[stack.peek()] >= temp[i]) {
        stack.pop();
      }
      nsr.add(stack.isEmpty() ? n : stack.peek());
      stack.add(i);
    }
    Collections.reverse(nsr);
    return nsr;
  }
}
