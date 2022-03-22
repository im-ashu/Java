package com.designpattern.behavioral.visitor;

public class ComputerPartCheckingVisitor implements ComputerPartVisitor {

  @Override
  public void visit(Computer computer) {
    System.out.println("Checking computer");
  }

  @Override
  public void visit(Monitor monitor) {
    System.out.println("Checking monitor");
  }

  @Override
  public void visit(KeyBoard keyBoard) {
    System.out.println("Checking keyBoard");
  }

  @Override
  public void visit(Mouse mouse) {
    System.out.println("Checking mouse");
  }
}
