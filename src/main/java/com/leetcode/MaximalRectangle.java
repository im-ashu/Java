package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaximalRectangle {

  public static void main(String[] args) {
    char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    MaximalRectangle maximalRectangle = new MaximalRectangle();
    System.out.println(maximalRectangle.maximalRectangle(matrix));
  }

  public int maximalRectangle(char[][] matrix) {
    int cols = matrix[0].length;

    int[] temp = new int[cols];
    int omax = 0;
    for (char[] chars : matrix) {
      for (int j = 0; j < cols; j++) {
        int val = chars[j] - '0';
        if (val == 0) {
          temp[j] = 0;
        } else {
          temp[j] += val;
        }
      }
      int max = mah(temp);
      omax = Math.max(omax, max);
    }
    return omax;
  }

  private int mah(int[] temp) {
    ArrayList<Integer> nsl = nsl(temp);
    ArrayList<Integer> nsr = nsr(temp);
    int maxArea = 0;
    for (int i = 0, n = temp.length; i < n; i++) {
      int area = (nsr.get(i) - nsl.get(i) - 1) * temp[i];
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
