package com.datastructure.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

  public static void main(String[] args) {
    int N = 5;
    ArrayList<String> result = generate(N);
    result.forEach(s -> System.out.print(s + " "));
  }

  static ArrayList<String> generate(int N) {
    // Your code here
    Queue<String> queue = new LinkedList<>();
    ArrayList<String> result = new ArrayList<>();
    queue.add("1");
    while (N-- > 0) {
      String number = queue.poll();
      result.add(number);
      queue.add(number + "0");
      queue.add(number + "1");
    }
    return result;

  }
}