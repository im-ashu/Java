package com.designpattern.creational.singleton;

public final class SingletonLazy {

  private static SingletonLazy instance;

  private SingletonLazy() {
  }

  public static SingletonLazy getInstance() {
    if (instance == null) {
      instance = new SingletonLazy();
    }
    return instance;
  }
}
