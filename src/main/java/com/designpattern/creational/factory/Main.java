package com.designpattern.creational.factory;

public class Main {

  public static void main(String[] args) {
    Shape circle = ShapeFactory.getCircle();
    Shape triangle = ShapeFactory.getTriangle();
    circle.draw();
    triangle.draw();
  }


}
