package com.datastructure.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class SortArrayUsingStack {

  public static void main(String... args) {
    int[] arr = {10, 5, 15, 45};
    int n = arr.length;

    sortArrayUsingStacks(arr, n);

    IntStream.range(0, n).forEach(i -> System.out.printf("%d ", arr[i]));
  }

  private static void sortArrayUsingStacks(int[] arr, int n) {
    Stack<Integer> stack = new Stack<>();
    Arrays.stream(arr).forEach(stack::push);
    Stack<Integer> tempStack = sortStack(stack);
    IntStream.range(0, n).forEach(i -> arr[i] = tempStack.pop());
  }

  private static Stack<Integer> sortStack(Stack<Integer> input) {
    Stack<Integer> stack = new Stack<>();
    while (!input.isEmpty()) {
      int element = input.pop();
      while (!stack.isEmpty() && stack.peek() < element) {
        input.push(stack.pop());
      }
      stack.push(element);
    }
    return stack;
  }
}
