package com.designpattern.creational.singleton;

public final class SingletonEager {

  private static final SingletonEager INSTANCE = new SingletonEager();

  private SingletonEager() {

  }

  public static SingletonEager getInstance() {
    return INSTANCE;
  }
}
