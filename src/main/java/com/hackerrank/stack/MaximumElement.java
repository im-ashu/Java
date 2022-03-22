package com.hackerrank.stack;


import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    int n = scanner.nextInt();
    SpecialStack stack = new SpecialStack();
    for (int i = 1; i <= n + 1; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      if (queriesRowItems[0].equals(Operation.ADD.getOperation())) {
        stack.push(Integer.parseInt(queriesRowItems[1]));
      } else if (queriesRowItems[0].equals(Operation.DELETE.getOperation())) {
        stack.pop();
      } else {
        if (stack.getMax() != Integer.MIN_VALUE) {
          System.out.println(stack.getMax());
        }
      }
    }
  }

  enum Operation {
    ADD("1"), DELETE("2"), MAX("3");
    private final String operation;

    Operation(String s) {
      this.operation = s;
    }

    public String getOperation() {
      return operation;
    }
  }

  static class SpecialStack extends Stack<Integer> {

    int max;

    @Override
    public Integer push(Integer item) {
      if (isEmpty()) {
        max = item;
        return super.push(item);
      }
      if (max < item) {
        int temp = (2 * item) - max;
        max = item;
        return super.push(temp);
      }
      return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
      int item = super.pop();
      if (max < item) {
        int temp = max;
        max = (2 * max) - item;
        return temp;
      }
      return item;
    }

    public int getMax() {
      if (isEmpty()) {
        return Integer.MIN_VALUE;
      }
      return max;
    }
  }
}

