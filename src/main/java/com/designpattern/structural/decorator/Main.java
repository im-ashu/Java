package com.designpattern.structural.decorator;

public class Main {

  public static void main(String[] args) {
    Shape circle = new Circle();
    Shape redCircle = new RedShapeDecorator(new Circle());
    Shape redRectangle = new RoundShapeDecorator(new RedShapeDecorator(new Rectangle()));
    circle.draw();
    redCircle.draw();
    redRectangle.draw();
  }
}
