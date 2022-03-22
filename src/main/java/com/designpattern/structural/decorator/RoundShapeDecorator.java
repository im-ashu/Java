package com.designpattern.structural.decorator;

public class RoundShapeDecorator extends ShapeDecorator {

  public RoundShapeDecorator(Shape shape) {
    super(shape);
  }

  @Override
  public void draw() {
    super.draw();
    System.out.println("Border : Round");
  }
}
