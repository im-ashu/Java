package com.designpattern.structural.bridge;

public abstract class Shape {

  protected final DrawApi drawApi;

  protected Shape(DrawApi drawApi) {
    this.drawApi = drawApi;
  }

  public abstract void draw();

}
