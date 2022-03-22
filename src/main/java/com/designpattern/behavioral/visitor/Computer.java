package com.designpattern.behavioral.visitor;

import java.util.Arrays;
import java.util.List;

public class Computer implements ComputerPart {

  private List<ComputerPart> parts = Arrays.asList(new Mouse(), new KeyBoard(), new Monitor());

  @Override
  public void accept(ComputerPartVisitor visitor) {
    for (ComputerPart part : parts) {
      part.accept(visitor);
    }
    visitor.visit(this);
  }
}
