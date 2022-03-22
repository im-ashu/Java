package com.hackerrank.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStacks {

  private static final Scanner scanner = new Scanner(System.in);

  /*
   * Complete the twoStacks function below.
   */
  static int twoStacks(int x, int[] a, int[] b) {
    /*
     * Write your code here.
     */
    Stack<Integer> stackOfA = new Stack<>();
    Stack<Integer> stackOfB = new Stack<>();
    int count = 0;
    int sizeOfA = a.length;
    int sizeOfB = b.length;
    for (int i = sizeOfA - 1; i >= 0; i--) {
      stackOfA.push(a[i]);
    }
    for (int j = sizeOfB - 1; j >= 0; j--) {
      stackOfB.push(b[j]);
    }

    while (!stackOfA.isEmpty() && !stackOfB.isEmpty()) {
      if (x < stackOfA.peek() && x < stackOfB.peek()) {
        return count;
      }
      if (stackOfA.peek() < stackOfB.peek()) {
        x -= stackOfA.pop();
      } else {
        x -= stackOfB.pop();
      }
      count++;
    }
    while (!stackOfB.isEmpty() && stackOfB.peek() <= x) {
      x -= stackOfB.pop();
      count++;
    }
    while (!stackOfA.isEmpty() && stackOfA.peek() <= x) {
      x -= stackOfA.pop();
      count++;
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("GameOfTwoStacks.txt"));

    int g = Integer.parseInt(scanner.nextLine().trim());

    for (int gItr = 0; gItr < g; gItr++) {
      String[] nmx = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nmx[0].trim());

      int m = Integer.parseInt(nmx[1].trim());

      int x = Integer.parseInt(nmx[2].trim());

      int[] a = new int[n];

      String[] aItems = scanner.nextLine().split(" ");

      for (int aItr = 0; aItr < n; aItr++) {
        int aItem = Integer.parseInt(aItems[aItr].trim());
        a[aItr] = aItem;
      }

      int[] b = new int[m];

      String[] bItems = scanner.nextLine().split(" ");

      for (int bItr = 0; bItr < m; bItr++) {
        int bItem = Integer.parseInt(bItems[bItr].trim());
        b[bItr] = bItem;
      }

      int result = twoStacks(x, a, b);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();
  }
}
