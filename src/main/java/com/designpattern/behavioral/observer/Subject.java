package com.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

  private final List<Observer> observers;
  private int state;

  public Subject() {
    observers = new ArrayList<>();
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
    notifyAllObservers();
  }

  public void attach(Observer observer) {
    observers.add(observer);
  }

  public void notifyAllObservers() {
    observers.forEach(Observer::update);
  }

}
