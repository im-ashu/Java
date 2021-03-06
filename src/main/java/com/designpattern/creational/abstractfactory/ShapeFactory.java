package com.designpattern.creational.abstractfactory;

import static com.designpattern.creational.abstractfactory.ShapeType.RECTANGLE;
import static com.designpattern.creational.abstractfactory.ShapeType.SQUARE;

public class ShapeFactory extends AbstractFactory {

  @Override
  public Shape getShape(ShapeType shapeType) {
    if (shapeType.equals(RECTANGLE)) {
      return new Rectangle();
    } else if (shapeType.equals(SQUARE)) {
      return new Square();
    }
    return null;
  }
}
