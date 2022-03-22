package com.designpattern.creational.factory;

public class ShapeFactory {

  private static final String TRIANGLE = "TRIANGLE";
  private static final String CIRCLE = "CIRCLE";

  private static Shape getShapeInstance(String shape) {
    if (shape.equals(CIRCLE)) {
      return new Circle();
    } else if (shape.equals(TRIANGLE)) {
      return new Triangle();
    }
    return null;
  }

  public static Shape getCircle() {
    return getShapeInstance(CIRCLE);
  }

  public static Shape getTriangle() {
    return getShapeInstance(TRIANGLE);
  }

}
