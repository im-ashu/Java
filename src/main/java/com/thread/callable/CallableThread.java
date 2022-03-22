package com.thread.callable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<CallableResult> {

  private final String threadName;

  public CallableThread(String s) {
    this.threadName = s;
  }

  @Override
  public CallableResult call() throws Exception {
    return new CallableResult(200, threadName);
  }
}
