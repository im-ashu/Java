package com.designpattern.behavioral.chain;

public class FileLogger extends AbstractLogger {

  public FileLogger(int level) {
    super(level);
  }

  @Override
  protected void write(String message) {
    System.out.println("Standard File::Logger " + message);
  }
}
