package com.datastructure.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {

  public static void main(String[] args) {
    int[][] binaryMatrix = {{0, 1, 1, 0},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0}};
    int row = binaryMatrix.length;
    int column = binaryMatrix[0].length;
    int[] arr = new int[column];
    int max = Integer.MIN_VALUE;

    for (int[] matrix : binaryMatrix) {
      for (int j = 0; j < column; j++) {
        arr[j] = (matrix[j] == 0) ? 0 : (arr[j] + matrix[j]);
      }
      int area = maxAreaHistogram(arr, column);
      if (max < area) {
        max = area;
      }
    }
    System.out.println(max);
  }

  private static int maxAreaHistogram(int[] arr, int n) {
    ArrayList<Integer> nslIndex = generateIndexesNSL(arr, n);
    ArrayList<Integer> nsrIndex = generateIndexesNSR(arr, n);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int width = nsrIndex.get(i) - nslIndex.get(i) - 1;
      int area = width * arr[i];
      if (max < area) {
        max = area;
      }
    }
    return max;
  }

  private static ArrayList<Integer> generateIndexesNSR(int[] arr, int n) {
    ArrayList<Integer> nse = new ArrayList<>(n);
    Stack<Integer> stack = new Stack<>();
    int pseudoIndex = n;
    for (int i = n - 1; i >= 0; i--) {
      nextSmallerCommon(nse, stack, arr, i, pseudoIndex);
    }
    Collections.reverse(nse);
    return nse;
  }

  private static ArrayList<Integer> generateIndexesNSL(int[] arr, int n) {
    ArrayList<Integer> nse = new ArrayList<>(n);
    Stack<Integer> stack = new Stack<>();
    int pseudoIndex = -1;
    for (int i = 0; i < n; i++) {
      nextSmallerCommon(nse, stack, arr, i, pseudoIndex);
    }
    return nse;
  }

  private static void nextSmallerCommon(ArrayList<Integer> nse, Stack<Integer> stack, int[] arr,
      int index, int pseudoIndex) {
    while (!stack.isEmpty() && arr[stack.peek()] >= arr[index]) {
      stack.pop();
    }
    nse.add(stack.isEmpty() ? pseudoIndex : stack.peek());
    stack.add(index);
  }

}