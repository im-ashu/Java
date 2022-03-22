package com.thread.forkjoin.recursiveaction;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    double[] numbers = new double[10];
    IntStream.range(0, 10).forEach(num -> numbers[num] = num);
    SqrtTransform task = new SqrtTransform(numbers, 0, numbers.length);
    forkJoinPool.invoke(task);
    Arrays.stream(numbers, 0, 10).forEach(number -> System.out.printf("%.4f ", number));
  }
}

class SqrtTransform extends RecursiveAction {

  final int threshold = 5;
  private final double[] numbers;
  private final int start;
  private final int end;

  public SqrtTransform(double[] numbers, int start, int end) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }

  @Override
  protected void compute() {
    if ((end - start) < threshold) {
      IntStream.range(start, end).forEach(num -> numbers[num] = Math.sqrt(numbers[num]));
    } else {
      int middle = (start) + ((end - start) >> 1);
      invokeAll(new SqrtTransform(numbers, start, middle),
          new SqrtTransform(numbers, middle, end));
    }
  }
}
