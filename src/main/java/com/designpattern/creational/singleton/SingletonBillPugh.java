package com.designpattern.creational.singleton;

public final class SingletonBillPugh {

  private SingletonBillPugh() {
  }

  public static SingletonBillPugh getInstance() {
    return SingletonBillPughHelper.INSTANCE;
  }

  private static final class SingletonBillPughHelper {

    private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
  }
}
