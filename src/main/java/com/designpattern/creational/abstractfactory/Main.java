package com.designpattern.creational.abstractfactory;

import static com.designpattern.creational.abstractfactory.ShapeType.RECTANGLE;

public class Main {

  public static void main(String[] args) {
    AbstractFactory factory = FactoryProducer.getFactory(true);
    Shape rectangle = factory.getShape(RECTANGLE);
    rectangle.draw();

    factory = FactoryProducer.getFactory(false);
    Shape rectangle1 = factory.getShape(RECTANGLE);
    rectangle1.draw();

  }
}
