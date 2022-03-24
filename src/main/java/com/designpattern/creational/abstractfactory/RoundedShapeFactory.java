package com.designpattern.creational.abstractfactory;

import static com.designpattern.creational.abstractfactory.ShapeType.RECTANGLE;
import static com.designpattern.creational.abstractfactory.ShapeType.SQUARE;

public class RoundedShapeFactory extends AbstractFactory {

  @Override
  public Shape getShape(ShapeType shapeType) {
    if (shapeType.equals(RECTANGLE)) {
      return new RoundedRectangle();
    } else if (shapeType.equals(SQUARE)) {
      return new RoundedSquare();
    }
    return null;
  }
}
