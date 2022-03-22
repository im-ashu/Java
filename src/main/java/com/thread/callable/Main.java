package com.thread.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CallableThread thread1 = new CallableThread("Thread 1");
    CallableThread thread2 = new CallableThread("Thread 2");

    List<CallableThread> callableTasks = Arrays.asList(thread1, thread2);
    List<Future<CallableResult>> resultList;
    try {
      resultList = executorService.invokeAll(callableTasks);
    } catch (InterruptedException e) {
      throw e;
    }

    resultList.forEach(future -> {
      try {
        getResult(future);
      } catch (ExecutionException | InterruptedException e) {
        e.printStackTrace();
      }
    });

    Future<CallableResult> resultThread1 = executorService.submit(thread1);

    if (resultThread1.isDone()) {
      CallableResult callableResult = resultThread1.get();
      System.out.println(callableResult.getCode());
    }

    executorService.shutdown();
  }

  private static void getResult(Future<CallableResult> future)
      throws ExecutionException, InterruptedException {
    if (future.isDone()) {
      CallableResult callableResult;
      try {
        callableResult = future.get();
      } catch (InterruptedException | ExecutionException e) {
        throw e;
      }
      System.out.println(callableResult.getMessage());
    }
  }
}
