package com.designpattern.creational.singleton;

class SingletonParent implements Cloneable {

  @Override
  public SingletonParent clone() throws CloneNotSupportedException {
    try {
      return (SingletonParent) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}

public final class SingletonCloneSafe extends SingletonParent {

  private static SingletonCloneSafe instance;

  private SingletonCloneSafe() {
  }

  public static SingletonCloneSafe getInstance() {
    if (instance == null) {
      instance = new SingletonCloneSafe();
    }
    return instance;
  }

  @Override
  public SingletonParent clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Clone is not supported for Singleton class");
  }
}
