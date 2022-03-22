package com.designpattern.behavioral.visitor;

public class KeyBoard implements ComputerPart {

  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visit(this);
  }
}
