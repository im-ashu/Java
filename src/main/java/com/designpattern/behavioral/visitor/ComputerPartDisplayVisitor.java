package com.designpattern.behavioral.visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

  @Override
  public void visit(Computer computer) {
    System.out.println("Displaying computer");
  }

  @Override
  public void visit(Monitor monitor) {
    System.out.println("Displaying monitor");
  }

  @Override
  public void visit(KeyBoard keyBoard) {
    System.out.println("Displaying keyBoard");
  }

  @Override
  public void visit(Mouse mouse) {
    System.out.println("Displaying mouse");
  }
}
