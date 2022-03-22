package com.designpattern.structural.facade;

public class ShapeMaker {

  private final Shape circle;
  private final Shape rectangle;

  public ShapeMaker() {
    this.circle = new Circle();
    this.rectangle = new Rectangle();
  }

  public void drawCircle() {
    circle.draw();
  }

  public void drawRectangle() {
    rectangle.draw();
  }
}
