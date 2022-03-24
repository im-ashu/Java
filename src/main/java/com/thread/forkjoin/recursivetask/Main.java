package com.thread.forkjoin.recursivetask;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    double[] numbers = new double[5000];
    IntStream.range(0, 5000).forEach(num -> numbers[num] = (num % 2 == 0) ? num : -1);
    Sum task = new Sum(numbers, 0, numbers.length);
    Double sum = forkJoinPool.invoke(task);
    System.out.println("Summation : " + sum);
  }
}

class Sum extends RecursiveTask<Double> {

  private final int seqThreshold = 500;
  private final double[] data;
  private final int start;
  private final int end;

  public Sum(double[] data, int start, int end) {
    this.data = data;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Double compute() {
    double sum = 0;
    if (end - start < seqThreshold) {
      sum = Arrays.stream(data, start, end).sum();
    } else {
      int middle = (start + end) / 2;
      Sum subTaskA = new Sum(data, start, middle);
      Sum subTaskB = new Sum(data, middle, end);
      subTaskA.fork();
      subTaskB.fork();
      sum += subTaskA.join() + subTaskB.join();
    }
    return sum;
  }
}

