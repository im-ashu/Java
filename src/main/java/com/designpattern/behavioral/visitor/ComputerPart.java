package com.designpattern.behavioral.visitor;

public interface ComputerPart {

  void accept(ComputerPartVisitor visitor);
}
