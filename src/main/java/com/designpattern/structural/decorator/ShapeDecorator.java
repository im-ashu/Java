package com.designpattern.structural.decorator;

public abstract class ShapeDecorator implements Shape {

  protected final Shape shape;

  public ShapeDecorator(Shape shape) {
    this.shape = shape;
  }

  public void draw() {
    shape.draw();
  }
}
