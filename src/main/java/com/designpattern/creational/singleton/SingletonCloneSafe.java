package com.designpattern.creational.singleton;

class SingletonParent implements Cloneable {

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
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Clone is not supported for Singleton class");
  }
}
