package com.hackerrank.stack;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {

  private static final Scanner scanner = new Scanner(System.in);

  /*
   * Complete the equalStacks function below.
   */
  static int equalStacks(int[] h1, int[] h2, int[] h3) {
    /*
     * Write your code here.
     */

    /*LinkedHashSet<Integer> m1 = new LinkedHashSet<>();
    LinkedHashSet<Integer> m2 = new LinkedHashSet<>();
    LinkedHashSet<Integer> m3 = new LinkedHashSet<>();

    reverse(h1);
    reverse(h2);
    reverse(h3);

    Arrays.parallelPrefix(h1, Integer::sum);
    IntStream.of(h1).forEach(m1::add);
    Arrays.parallelPrefix(h2, Integer::sum);
    IntStream.of(h2).filter(m1::contains).forEach(m2::add);
    Arrays.parallelPrefix(h3, Integer::sum);
    IntStream.of(h3).filter(m2::contains).forEach(m3::add);*/

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    Stack<Integer> s3 = new Stack();
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    int i;
    for (i = h1.length - 1; i >= 0; i--) {
      s1.push(h1[i]);
      sum1 += h1[i];
    }
    for (i = h2.length - 1; i >= 0; i--) {
      s2.push(h2[i]);
      sum2 += h2[i];
    }
    for (i = h3.length - 1; i >= 0; i--) {
      s3.push(h3[i]);
      sum3 += h3[i];
    }
    while ((sum2 != sum3) || (sum3 != sum1)) {
      if (sum1 == 0 || sum2 == 0 || sum3 == 0) {
        sum1 = 0;
        break;
      } else {
        if (sum1 >= sum2 && sum1 >= sum3) {
          sum1 -= s1.peek();
          s1.pop();
        } else if (sum2 >= sum1 && sum2 >= sum3) {
          sum2 -= s2.peek();
          s2.pop();
        } else if (sum3 >= sum1 && sum3 >= sum2) {
          sum3 -= s3.peek();
          s3.pop();
        }
      }
    }
    return sum1;
  }

  private static void reverse(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    int temp;
    while (start < end) {
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("EqualStacks.txt"));

    String[] n1N2N3 = scanner.nextLine().split(" ");

    int n1 = Integer.parseInt(n1N2N3[0].trim());

    int n2 = Integer.parseInt(n1N2N3[1].trim());

    int n3 = Integer.parseInt(n1N2N3[2].trim());

    int[] h1 = new int[n1];

    String[] h1Items = scanner.nextLine().split(" ");

    for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
      int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
      h1[h1Itr] = h1Item;
    }

    int[] h2 = new int[n2];

    String[] h2Items = scanner.nextLine().split(" ");

    for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
      int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
      h2[h2Itr] = h2Item;
    }

    int[] h3 = new int[n3];

    String[] h3Items = scanner.nextLine().split(" ");

    for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
      int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
      h3[h3Itr] = h3Item;
    }

    int result = equalStacks(h1, h2, h3);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();
  }

  private static String apply(Integer s) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(s);
    stringBuilder.append(" ");
    return stringBuilder.toString();
  }
}

